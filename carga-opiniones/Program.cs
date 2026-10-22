using System.Text;
using CargaOpiniones.Modelos;
using CargaOpiniones.Servicios;

Console.OutputEncoding = Encoding.UTF8;

var cargador = new Cargador();
var resultados = new List<Resultado>();

Console.WriteLine("=== PROCESO DE CARGA - OPINIONES DE CLIENTES ===");

resultados.Add(cargador.Cargar("Fuentes de datos", "Datos/fuentes.csv", "fuente"));
resultados.Add(cargador.Cargar("Clientes", "Datos/clientes.csv", "cliente"));
resultados.Add(cargador.Cargar("Productos", "Datos/productos.csv", "producto"));
resultados.Add(cargador.Cargar("Opiniones", "Datos/opiniones.csv", "opinion"));

foreach (var r in resultados)
{
    Console.WriteLine();
    Console.WriteLine("--- " + r.Nombre + " ---");
    Console.WriteLine("Procesados: " + r.Procesados + " | Insertados: " + r.Insertados + " | Rechazados: " + r.Rechazados);
    foreach (var e in r.Errores)
    {
        Console.WriteLine("   " + e);
    }
}

int totalProcesados = resultados.Sum(r => r.Procesados);
int totalInsertados = resultados.Sum(r => r.Insertados);
int totalRechazados = resultados.Sum(r => r.Rechazados);

Console.WriteLine();
Console.WriteLine("=== RESUMEN FINAL ===");
Console.WriteLine("Total procesados: " + totalProcesados);
Console.WriteLine("Total insertados: " + totalInsertados);
Console.WriteLine("Total rechazados: " + totalRechazados);
