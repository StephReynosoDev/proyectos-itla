package hacker;

import javax.swing.JTextArea;

public abstract class Hacker {

    private String nombre;
    private int nivelAcceso;

    public Hacker(String nombre, int nivelAcceso) {
        this.nombre = nombre;
        this.nivelAcceso = nivelAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void hablar(JTextArea consola, String mensaje) {
        consola.append("[" + nombre + "]: " + mensaje + "\n");
    }

    public abstract void infiltrar(JTextArea consola);
}