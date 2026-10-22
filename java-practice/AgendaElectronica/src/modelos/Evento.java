package modelos;

public class Evento {
    private int id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private String lugar;

    public Evento(int id, String titulo, String descripcion,
                  String fecha, String hora, String lugar) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getLugar() { return lugar; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHora(String hora) { this.hora = hora; }
    public void setLugar(String lugar) { this.lugar = lugar; }
}