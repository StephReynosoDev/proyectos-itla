package hacker;

import javax.swing.JTextArea;

public class Anonymous extends Hacker implements HabilidadEspecial {

    public Anonymous(String nombre, int nivelAcceso) {
        super(nombre, nivelAcceso);
    }

    @Override
    public void infiltrar(JTextArea consola) {
        consola.append("\n");
        consola.append("        .########.         \n");
        consola.append("      ##          ##       \n");
        consola.append("    ##   ##    ##   ##     \n");
        consola.append("    ##   ##    ##   ##     \n");
        consola.append("    ##     ####     ##     \n");
        consola.append("    ##   ##    ##   ##     \n");
        consola.append("      ##          ##       \n");
        consola.append("        '########'         \n");
        consola.append("     We Are Anonymous      \n");
        consola.append("     We Are Legion         \n");
        consola.append("     We Do Not Forgive     \n");
        consola.append("     We Do Not Forget      \n");
        consola.append("\n");
        consola.append("[" + getNombre() + "]: Nivel de acceso " + getNivelAcceso() + " - Identidad oculta. Presencia confirmada\n");
    }

    @Override
    public void activarHabilidad(JTextArea consola) {
        consola.append("[" + getNombre() + "]: Activando modo invisible...\n");
        consola.append("  >>> IDENTITY: NULL\n");
        consola.append("  >>> LOCATION: UNKNOWN\n");
        consola.append("  >>> TRACE: IMPOSSIBLE\n");
    }
}