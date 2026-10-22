package hacker;

import javax.swing.SwingUtilities;

public class HackerSimulator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HackerFrame frame = new HackerFrame();
            frame.setVisible(true);
        });
    }
}