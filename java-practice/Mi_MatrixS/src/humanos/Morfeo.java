package humanos;

import javax.swing.JTextArea;

public class Morfeo extends Humanos {

    public Morfeo(String name, boolean esLevantado) {
        super(name, esLevantado);
    }

    public void levantar(Humanos human, JTextArea consola) {
        consola.append(name + ": Te mostrare el camino\n");
        human.esLevantado = true;
    }
}