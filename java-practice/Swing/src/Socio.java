
public class Socio {

    private String nombre;
    private int numero;
    private static int proximoNumero = 1;

    public Socio(String nombre) {
        this.nombre = nombre;
        this.numero = proximoNumero;
        proximoNumero++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public static int getProximoNumero() {
        return proximoNumero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static void setProximoNumero(int proximoNumero) {
        Socio.proximoNumero = proximoNumero;
    }
}