using System.Data;
using Microsoft.Data.SqlClient;
using CargaOpiniones.Modelos;

namespace CargaOpiniones.Servicios;

public class Cargador
{
    private readonly string cadenaConexion = "Server=STEPH\\SQLEXPRESS;Database=OpinionesClientes;Trusted_Connection=True;TrustServerCertificate=True;";
    private readonly Validador validador = new Validador();

    public Resultado Cargar(string nombre, string ruta, string tipo)
    {
        var resultado = new Resultado { Nombre = nombre };

        if (!File.Exists(ruta))
        {
            resultado.Errores.Add("No se encontro el archivo " + ruta);
            return resultado;
        }

        string[] lineas = File.ReadAllLines(ruta);

        try
        {
            using var con = new SqlConnection(cadenaConexion);
            con.Open();

            for (int i = 1; i < lineas.Length; i++)
            {
                if (string.IsNullOrWhiteSpace(lineas[i])) continue;

                resultado.Procesados++;
                string[] c = lineas[i].Split(',');
                for (int j = 0; j < c.Length; j++) c[j] = c[j].Trim();

                string error = "";
                try
                {
                    switch (tipo)
                    {
                        case "cliente": error = ProcesarCliente(con, c); break;
                        case "producto": error = ProcesarProducto(con, c); break;
                        case "fuente": error = ProcesarFuente(con, c); break;
                        case "opinion": error = ProcesarOpinion(con, c); break;
                        default: error = "Tipo de archivo no reconocido"; break;
                    }
                }
                catch (SqlException ex)
                {
                    error = "Error de base de datos: " + ex.Message;
                }

                if (error == "")
                {
                    resultado.Insertados++;
                }
                else
                {
                    resultado.Rechazados++;
                    resultado.Errores.Add("Linea " + (i + 1) + ": " + error);
                }
            }
        }
        catch (Exception ex)
        {
            resultado.Errores.Add("Error general: " + ex.Message);
        }

        return resultado;
    }

    private string ProcesarCliente(SqlConnection con, string[] c)
    {
        if (c.Length != 2) return "Estructura incorrecta, se esperaban 2 columnas";
        if (c[0] == "") return "El nombre es obligatorio";
        if (!validador.CorreoValido(c[1])) return "Correo invalido";

        int filas = Ejecutar(con, "sp_InsertarCliente",
            new SqlParameter("@nombre", c[0]),
            new SqlParameter("@correo", c[1]));
        return filas == 1 ? "" : "Registro duplicado";
    }

    private string ProcesarProducto(SqlConnection con, string[] c)
    {
        if (c.Length != 2) return "Estructura incorrecta, se esperaban 2 columnas";
        if (c[0] == "") return "El nombre del producto es obligatorio";
        if (c[1] == "") return "La categoria es obligatoria";

        int filas = Ejecutar(con, "sp_InsertarProducto",
            new SqlParameter("@nombre", c[0]),
            new SqlParameter("@categoria", c[1]));
        return filas == 1 ? "" : "Registro duplicado";
    }

    private string ProcesarFuente(SqlConnection con, string[] c)
    {
        if (c.Length != 1) return "Estructura incorrecta, se esperaba 1 columna";
        if (c[0] == "") return "El nombre de la fuente es obligatorio";

        int filas = Ejecutar(con, "sp_InsertarFuente", new SqlParameter("@nombre", c[0]));
        return filas == 1 ? "" : "Registro duplicado";
    }

    private string ProcesarOpinion(SqlConnection con, string[] c)
    {
        if (c.Length != 6) return "Estructura incorrecta, se esperaban 6 columnas";
        if (!validador.CorreoValido(c[0])) return "Correo invalido";
        if (c[1] == "" || c[2] == "") return "Producto y fuente son obligatorios";
        if (!validador.CalificacionValida(c[3], out int calificacion)) return "Calificacion invalida, debe ser un numero del 1 al 5";
        if (c[4] == "") return "El comentario es obligatorio";
        if (!validador.FechaValida(c[5], out DateTime fecha)) return "Fecha invalida, formato esperado yyyy-MM-dd";

        int idCliente = BuscarId(con, "SELECT id_cliente FROM Cliente WHERE correo = @valor", c[0]);
        if (idCliente == 0) return "Integridad referencial: el cliente no existe";

        int idProducto = BuscarId(con, "SELECT id_producto FROM Producto WHERE nombre = @valor", c[1]);
        if (idProducto == 0) return "Integridad referencial: el producto no existe";

        int idFuente = BuscarId(con, "SELECT id_fuente FROM FuentesDatos WHERE nombre = @valor", c[2]);
        if (idFuente == 0) return "Integridad referencial: la fuente no existe";

        int filas = Ejecutar(con, "sp_InsertarOpinion",
            new SqlParameter("@id_cliente", idCliente),
            new SqlParameter("@id_producto", idProducto),
            new SqlParameter("@id_fuente", idFuente),
            new SqlParameter("@calificacion", calificacion),
            new SqlParameter("@comentario", c[4]),
            new SqlParameter("@fecha", fecha));
        return filas == 1 ? "" : "Registro duplicado";
    }

    private int Ejecutar(SqlConnection con, string procedimiento, params SqlParameter[] parametros)
    {
        using var cmd = new SqlCommand(procedimiento, con);
        cmd.CommandType = CommandType.StoredProcedure;
        cmd.Parameters.AddRange(parametros);
        return Convert.ToInt32(cmd.ExecuteScalar());
    }

    private int BuscarId(SqlConnection con, string sql, string valor)
    {
        using var cmd = new SqlCommand(sql, con);
        cmd.Parameters.AddWithValue("@valor", valor);
        object? r = cmd.ExecuteScalar();
        return r == null ? 0 : Convert.ToInt32(r);
    }
}
