package matrix;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

import humanos.Neo;
import humanos.Morfeo;
import humanos.Humanos;
import agentes.Smith;

public class MatrixFrame extends JFrame {
    JTextArea consola;
    JButton correrBtn;
    
    public MatrixFrame() {
        setTitle("Matrix Simulador");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        consola = new JTextArea();
        consola.setBackground(Color.BLACK);
        consola.setForeground(Color.GREEN);
        consola.setFont(new Font("Monospaced", Font.PLAIN, 16));
        consola.setEditable(false);

        correrBtn = new JButton("Correr simulacion");
        correrBtn.addActionListener(e -> correrSimulacion());

        add(new JScrollPane(consola), BorderLayout.CENTER);
        add(correrBtn, BorderLayout.SOUTH);

        PanelLluvia panelLL = new PanelLluvia(getWidth(), getHeight());
        setGlassPane(panelLL);
        panelLL.setVisible(true);
    }

    void correrSimulacion() {
        iniciarSimulacion();
    }

    void iniciarSimulacion() {
        consola.setText("");
        print("Bienvenidos a la matrix\n\n");
        print("Corriendo simulacion...\n");

        Neo neo = new Neo("Thomas Anderson", false);
        Morfeo morfeo = new Morfeo("Morfeo", true);
        Smith smith = new Smith("Smith");

        morfeo.speak(consola, "He despertado al elegido\n");
        ((Morfeo) morfeo).levantar(neo, consola);
        neo.speak(consola, "Ahora puedo creer\n");
        ((Neo) neo).desbloquearPoder(consola);
        smith.interceptar(neo, consola);
        neo.seSacrifica(consola);
        
        print("La matriz se reinicia\n");
    }

    void print(String mensaje) {
        consola.append(mensaje);
    }
}