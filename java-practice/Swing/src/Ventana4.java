
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Ventana4 extends JFrame {

    JTextField campoPelicula;
    JComboBox<String> listaPeliculas;

    public Ventana4() {
        setTitle("Lista de Peliculas");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        campoPelicula = new JTextField(15);
        listaPeliculas = new JComboBox<>();
        JButton btnAnadir = new JButton("Añadir");

        panel.add(new JLabel("Pelicula:"));
        panel.add(campoPelicula);
        panel.add(btnAnadir);
        panel.add(new JLabel("Lista:"));
        panel.add(listaPeliculas);

        btnAnadir.addActionListener(e -> anadirPelicula());

        add(panel);
        setVisible(true);
    }

    void anadirPelicula() {
        String nombre = campoPelicula.getText().trim();
        if (!nombre.isEmpty()) {
            listaPeliculas.addItem(nombre);
            campoPelicula.setText("");
        }
    }
}