package agentes;

import javax.swing.JTextArea;
import humanos.Humanos;

public class Smith extends Agentes {

    public Smith(String name) {
        super(name);
    }

    @Override
    public void interceptar(Humanos humano, JTextArea consola) {
        consola.append(name + ": Senor " + humano.name + " es su ultima oportunidad\n");
    }

    public void replicar(JTextArea consola) {
        consola.append("Smith se replica\n");
    }
}