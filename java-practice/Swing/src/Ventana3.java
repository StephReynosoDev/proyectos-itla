
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;

public class Ventana3 extends JFrame {

    JRadioButton rbWindows;
    JRadioButton rbLinux;
    JRadioButton rbMac;
    JCheckBox cbProgramacion;
    JCheckBox cbDiseno;
    JCheckBox cbAdministracion;
    JSlider sliderHoras;
    JLabel labelHoras;

    public Ventana3() {
        setTitle("Mini Encuesta");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel(" Elija solo uno de los Sistemas Operativos:"));
        rbWindows = new JRadioButton("Windows");
        rbLinux = new JRadioButton("Linux");
        rbMac = new JRadioButton("Mac");

        ButtonGroup grupoSO = new ButtonGroup();
        grupoSO.add(rbWindows);
        grupoSO.add(rbLinux);
        grupoSO.add(rbMac);

        panel.add(rbWindows);
        panel.add(rbLinux);
        panel.add(rbMac);

        panel.add(new JLabel("Elija una Especialidad:"));
        cbProgramacion = new JCheckBox("Programacion");
        cbDiseno = new JCheckBox("Diseño Grafico");
        cbAdministracion = new JCheckBox("Administracion");

        panel.add(cbProgramacion);
        panel.add(cbDiseno);
        panel.add(cbAdministracion);

        panel.add(new JLabel("Horas en el ordenador:"));
        sliderHoras = new JSlider(0, 10, 0);
        labelHoras = new JLabel("Horas: 0");

        sliderHoras.addChangeListener(e -> {
            labelHoras.setText("Horas: " + sliderHoras.getValue());
        });

        panel.add(sliderHoras);
        panel.add(labelHoras);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(e -> mostrarResultado());
        panel.add(btnEnviar);

        add(panel);
        setVisible(true);
    }

    void mostrarResultado() {
        String so = "Ninguno";
        if (rbWindows.isSelected()) so = "Windows";
        else if (rbLinux.isSelected()) so = "Linux";
        else if (rbMac.isSelected()) so = "Mac";

        String especialidades = "";
        if (cbProgramacion.isSelected()) especialidades += "Programacion ";
        if (cbDiseno.isSelected()) especialidades += "Diseño Grafico ";
        if (cbAdministracion.isSelected()) especialidades += "Administracion";
        if (especialidades.isEmpty()) especialidades = "Ninguna";

        String mensaje = "Sistema: " + so + "\n"
                + "Especialidades: " + especialidades + "\n"
                + "Horas: " + sliderHoras.getValue();

        JOptionPane.showMessageDialog(this, mensaje);
    }
}