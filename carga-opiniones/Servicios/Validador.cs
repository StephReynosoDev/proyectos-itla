using System.Globalization;

namespace CargaOpiniones.Servicios;

public class Validador
{
    public bool CorreoValido(string correo)
    {
        if (string.IsNullOrWhiteSpace(correo)) return false;
        return correo.Contains("@") && correo.Contains(".") && !correo.Contains(" ");
    }

    public bool CalificacionValida(string texto, out int calificacion)
    {
        if (!int.TryParse(texto, out calificacion)) return false;
        return calificacion >= 1 && calificacion <= 5;
    }

    public bool FechaValida(string texto, out DateTime fecha)
    {
        return DateTime.TryParseExact(texto, "yyyy-MM-dd", CultureInfo.InvariantCulture, DateTimeStyles.None, out fecha);
    }
}
