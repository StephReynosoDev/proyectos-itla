package agentes;

import javax.swing.JTextArea;
import humanos.Humanos;

public abstract class Agentes {
    protected String name;

    public Agentes(String name) {
        this.name = name;
    }

    public abstract void interceptar(Humanos humano, JTextArea consola);
}