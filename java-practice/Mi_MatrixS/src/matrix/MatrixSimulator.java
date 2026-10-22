package matrix;

import javax.swing.SwingUtilities;

public class MatrixSimulator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MatrixFrame frame = new MatrixFrame();
            frame.setVisible(true);
        });
    }
}