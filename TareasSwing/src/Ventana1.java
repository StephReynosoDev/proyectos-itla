import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class Ventana1 extends JFrame {

    JTextField campoEscribir;
    JTextField campoEspejo;
    JCheckBox checkIzquierda;
    JCheckBox checkDerecha;

    public Ventana1() {
        setTitle("Imitador");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        campoEscribir = new JTextField(15);
        campoEspejo = new JTextField(15);
        campoEspejo.setEditable(false);

        checkIzquierda = new JCheckBox("Activo");
        checkDerecha = new JCheckBox("Activo");
        checkDerecha.setEnabled(false);

        panel.add(new JLabel("Escribe:"));
        panel.add(campoEscribir);
        panel.add(checkIzquierda);
        panel.add(new JLabel("  |  Espejo:"));
        panel.add(campoEspejo);
        panel.add(checkDerecha);

        campoEscribir.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e)  { copiarTexto(); }
            public void removeUpdate(DocumentEvent e)  { copiarTexto(); }
            public void changedUpdate(DocumentEvent e) { copiarTexto(); }
        });

        checkIzquierda.addActionListener(e -> {
            checkDerecha.setSelected(checkIzquierda.isSelected());
        });

        add(panel);
        setVisible(true);
    }

    void copiarTexto() {
        campoEspejo.setText(campoEscribir.getText());
    }
}