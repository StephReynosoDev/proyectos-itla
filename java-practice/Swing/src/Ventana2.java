
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Random;

public class Ventana2 extends JFrame {

    JSpinner spinnerMin;
    JSpinner spinnerMax;
    JTextField campoResultado;

    public Ventana2() {
        setTitle("Generador de Números");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        spinnerMin = new JSpinner();
        spinnerMax = new JSpinner();
        campoResultado = new JTextField(10);
        campoResultado.setEditable(false);

        JButton btnGenerar = new JButton("Generar");

        panel.add(new JLabel("Minimo:"));
        panel.add(spinnerMin);
        panel.add(new JLabel("Maximo:"));
        panel.add(spinnerMax);
        panel.add(btnGenerar);
        panel.add(new JLabel("Resultado:"));
        panel.add(campoResultado);

        btnGenerar.addActionListener(e -> generarNumero());

        add(panel);
        setVisible(true);
    }

    void generarNumero() {
        int min = (int) spinnerMin.getValue();
        int max = (int) spinnerMax.getValue();

        if (min > max) {
            JOptionPane.showMessageDialog(this, "El minimo no puede ser mayor que el maximo.");
            return;
        }

        Random random = new Random();
        int numero = random.nextInt((max - min) + 1) + min;
        campoResultado.setText(String.valueOf(numero));
    }
}