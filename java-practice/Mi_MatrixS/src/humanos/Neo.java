package humanos;

import javax.swing.JTextArea;

public class Neo extends Humanos implements UnaEleccion {

    public Neo(String name, boolean esLevantado) {
        super(name, esLevantado);
    }

    public void seSacrifica(JTextArea consola) {
        consola.append(name + ": Se sacrifica por la matrix\n");
    }

    @Override
    public void desbloquearPoder(JTextArea consola) {
        consola.append(name + ": desbloquea todo el poder y manipula la matriz");
    }
}