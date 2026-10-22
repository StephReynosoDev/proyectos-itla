package hacker;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class PanelLluvia extends JPanel implements Runnable {
    final char[] caracter = {'0', '1'};
    final int fontSize = 18;
    final int columns;
    final int[] yPosition;
    final Random random = new Random();

    public PanelLluvia(int ancho, int alto) {
        setBackground(Color.BLACK);
        setOpaque(false);

        columns = ancho / fontSize;
        yPosition = new int[columns];

        new Thread(this).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Monospaced", Font.BOLD, fontSize));
        g.setColor(new Color(180, 0, 255, 60));

        for (int i = 0; i < columns; i++) {
            char c = caracter[random.nextInt(caracter.length)];
            int x = i * fontSize;
            int y = yPosition[i] * fontSize;

            g.drawString(String.valueOf(c), x, y);

            if (y > getHeight() && random.nextInt(100) > 98) {
                yPosition[i] = 0;
            } else {
                yPosition[i]++;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}