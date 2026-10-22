package hacker;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class HackerFrame extends JFrame {

    JTextArea consola;
    JButton correrBtn;

    static final Color MORADO = new Color(180, 0, 255);

    static final String[] LOGS = {
        "[  OK  ] Iniciando Dragon Linux...",
        "[  OK  ] Cargando modulos del kernel...",
        "[  OK  ] Conectando a la red...",
        "[ INFO ] Escaneando puertos: 22, 80, 443, 8080...",
        "[ INFO ] Acceso al sistema detectado...",
        "[ WARN ] Firewall detectado... eliminando...",
        "[  OK  ] Root access granted...",
        "[ INFO ] Ejecutando protocolo de infiltracion...",
        "[  OK  ] Sistema comprometido al 100%...",
        "[ INFO ] Transfiriendo datos...",
        "[  OK  ] Proceso completado."
    };

    public HackerFrame() {
        setTitle("Dragon Linux - Hacker Simulator");
        setSize(750, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);

        consola = new JTextArea();
        consola.setBackground(Color.BLACK);
        consola.setForeground(MORADO);
        consola.setFont(new Font("Monospaced", Font.BOLD, 13));
        consola.setEditable(false);
        consola.setCaretColor(MORADO);

        correrBtn = new JButton(">> Correr simulacion <<");
        correrBtn.setBackground(Color.BLACK);
        correrBtn.setForeground(MORADO);
        correrBtn.setFont(new Font("Monospaced", Font.BOLD, 14));
        correrBtn.setFocusPainted(false);
        correrBtn.setBorder(javax.swing.BorderFactory.createLineBorder(MORADO, 2));
        correrBtn.addActionListener(e -> correrSimulacion());

        JPanel panelSur = new JPanel(new FlowLayout());
        panelSur.setBackground(Color.BLACK);
        panelSur.add(correrBtn);

        add(new JScrollPane(consola), BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        PanelLluvia panelLL = new PanelLluvia(getWidth(), getHeight());
        setGlassPane(panelLL);
        panelLL.setVisible(true);

        mostrarBienvenida();
    }

    void mostrarBienvenida() {
        consola.setText("");
        consola.append("=======================================================\n");
        consola.append("           DRAGON LINUX  -  HACKER EDITION             \n");
        consola.append("=======================================================\n");
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
        consola.append("\n=======================================================\n");
        consola.append("  Presiona el boton para iniciar la simulacion...\n");
        consola.append("=======================================================\n");
    }

    void correrSimulacion() {
        correrBtn.setEnabled(false);
        consola.setText("");

        Dragon dragon = new Dragon("Dragon", 5);
        Anonymous anon = new Anonymous("Anonymous", 4);

        consola.append("=======================================================\n");
        consola.append("           INICIANDO SECUENCIA HACKER...               \n");
        consola.append("=======================================================\n\n");

        Timer timer = new Timer(400, null);
        int[] index = {0};

        timer.addActionListener(e -> {
            if (index[0] < LOGS.length) {
                consola.append(LOGS[index[0]] + "\n");
                index[0]++;
            } else {
                timer.stop();

                dragon.infiltrar(consola);
                dragon.hablar(consola, "El sistema es nuestro\n");
                dragon.activarHabilidad(consola);

                consola.append("\n");

                anon.infiltrar(consola);
                anon.hablar(consola, "Nadie sabe quien somos\n");
                anon.activarHabilidad(consola);

                consola.append("\n");
                consola.append("=======================================================\n");
                consola.append("  El mundo digital esta en tus manos.\n");
                consola.append("  Eres el que elige...\n");
                consola.append("\n");
                consola.append("  Hacer el BIEN  o  hacer el MAL?\n");
                consola.append("\n");
                consola.append("  Dragon Linux... nada es imposible.\n");
                consola.append("=======================================================\n");

                correrBtn.setEnabled(true);
            }
        });

        timer.start();
    }
}