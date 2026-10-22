
public class MiBiblioteca {

    private String titulo;
    private boolean original;
    private boolean prestable;

    public String getTitulo() {
        return titulo;
    }

    public boolean getOriginal() {
        return original;
    }

    public boolean getPrestable() {
        return prestable;
    }

    public boolean esOriginal() {
        return original;
    }

    public boolean sePresta() {
        return prestable;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public void setPrestable(boolean prestable) {
        this.prestable = prestable;
    }
}