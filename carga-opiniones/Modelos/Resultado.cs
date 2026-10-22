namespace CargaOpiniones.Modelos;

public class Resultado
{
    public string Nombre { get; set; } = "";
    public int Procesados { get; set; }
    public int Insertados { get; set; }
    public int Rechazados { get; set; }
    public List<string> Errores { get; set; } = new List<string>();
}
