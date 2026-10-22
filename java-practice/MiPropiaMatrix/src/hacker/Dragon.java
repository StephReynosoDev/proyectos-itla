package hacker;

import javax.swing.JTextArea;

public class Dragon extends Hacker implements HabilidadEspecial {

    public Dragon(String nombre, int nivelAcceso) {
        super(nombre, nivelAcceso);
    }

    @Override
    public void infiltrar(JTextArea consola) {
        consola.append("\n");
        consola.append("          (\\                          \n");
        consola.append("          \\ \\                         \n");
        consola.append("          / /     .-'''-._            \n");
        consola.append("         / /     /  ~   ~ \\           \n");
        consola.append("        ( (     |  *   *   |          \n");
        consola.append("         \\ \\    \\   (__)   /          \n");
        consola.append("          \\ \\    `-.____.-'           \n");
        consola.append("      .----\\ \\---/        \\----.      \n");
        consola.append("     /      \\ \\ /   .--.   \\    \\     \n");
        consola.append("    /    .---\\ V /  /    \\  \\    \\    \n");
        consola.append("   /    /     \\_/  /  /\\  \\  \\    \\   \n");
        consola.append("  /    /           \\ /  \\ /   \\    \\  \n");
        consola.append(" (    /    .------. V    V      )      \n");
        consola.append("  \\  /    /        \\    /      /       \n");
        consola.append("   \\/____/          \\__/______/        \n");
        consola.append("\n");
        consola.append("[" + getNombre() + "]: Nivel de acceso " + getNivelAcceso() + " - Infiltracion completada\n");
    }

    @Override
    public void activarHabilidad(JTextArea consola) {
        consola.append("[" + getNombre() + "]: Activando fuego digital... todos los firewalls caen\n");
        consola.append("  >>> FIREWALL DESTROYED\n");
        consola.append("  >>> ROOT ACCESS GRANTED\n");
        consola.append("  >>> SISTEMA BAJO CONTROL\n");
    }
}