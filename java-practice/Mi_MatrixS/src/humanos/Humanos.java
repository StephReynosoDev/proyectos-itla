package humanos;

import javax.swing.JTextArea;

public class Humanos {
    public String name;
    protected boolean esLevantado;

    public Humanos(String name, boolean esLevantado) {
        this.name = name;
        this.esLevantado = esLevantado;
    }

    public void speak(JTextArea consola, String mensaje) {
        consola.append(name + ": " + mensaje + "\n");
    }
}