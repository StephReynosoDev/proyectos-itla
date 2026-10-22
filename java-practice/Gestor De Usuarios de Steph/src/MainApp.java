
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainApp extends JFrame {

	ArrayList<Usuario> listaUsuarios = new ArrayList<>();

	JTextField txtNombre = new JTextField(15);
	JTextField txtCorreo = new JTextField(15);
	JTextField txtContrasena = new JTextField(15);
	JTextField txtNivel = new JTextField(15);
	JComboBox<String> tipoUsuario = new JComboBox<>(new String[]{"Regular", "Administrador"});
	JTextArea areaTexto = new JTextArea(10, 30);

	class ValidadorDatos {
		boolean validarCorreo(String correo) {
			return correo.contains("@");
		}
	}

	public MainApp() {
		setTitle("Gestion de Usuarios");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(new JLabel("Nombre:"));
		add(txtNombre);
		add(new JLabel("Correo:"));
		add(txtCorreo);
		add(new JLabel("Contrasena:"));
		add(txtContrasena);
		add(new JLabel("Nivel Acceso:"));
		add(txtNivel);
		add(new JLabel("Tipo:"));
		add(tipoUsuario);

		JButton btnAgregar = new JButton("Agregar");
		JButton btnMostrar = new JButton("Mostrar");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnEditar = new JButton("Editar");

		add(btnAgregar);
		add(btnMostrar);
		add(btnEliminar);
		add(btnEditar);
		add(new JScrollPane(areaTexto));

		btnAgregar.addActionListener(e -> {
			ValidadorDatos v = new ValidadorDatos();
			if (!v.validarCorreo(txtCorreo.getText())) {
				JOptionPane.showMessageDialog(this, "Correo invalido");
				return;
			}
			if (tipoUsuario.getSelectedItem().equals("Administrador")) {
				listaUsuarios.add(new Administrador(txtNombre.getText(), txtCorreo.getText(), txtContrasena.getText(), txtNivel.getText()) {
					public String mostrarinfo() {
						return "Admin: " + getNombre() + " | Correo: " + getCorreo() + " | Nivel: " + getNivelAcceso();
					}
				});
			} else {
				listaUsuarios.add(new Usuario(txtNombre.getText(), txtCorreo.getText(), txtContrasena.getText()) {
					public String mostrarinfo() {
						return "Usuario: " + getNombre() + " | Correo: " + getCorreo(); 
					}
				});
			}
			JOptionPane.showMessageDialog(this, "Usuario agregado");
		});

		btnMostrar.addActionListener(e -> {
			areaTexto.setText("");
			for (int i = 0; i < listaUsuarios.size(); i++) {
				areaTexto.append(i + " - " + listaUsuarios.get(i).mostrarinfo() + "\n");
			}
		});

		btnEliminar.addActionListener(e -> {
			String input = JOptionPane.showInputDialog("Numero de usuario a eliminar:");
			int index = Integer.parseInt(input);
			listaUsuarios.remove(index);
			JOptionPane.showMessageDialog(this, "Usuario eliminado");
		});

		btnEditar.addActionListener(e -> {
			String input = JOptionPane.showInputDialog("Numero de usuario a editar:");
			int index = Integer.parseInt(input);
			if (tipoUsuario.getSelectedItem().equals("Administrador")) {
				listaUsuarios.set(index, new Administrador(txtNombre.getText(), txtCorreo.getText(), txtContrasena.getText(), txtNivel.getText()) {
					public String mostrarinfo() {
						return "Admin: " + getNombre() + " | Correo: " + getCorreo() + " | Nivel: " + getNivelAcceso();
					}
				});
			} else {
				listaUsuarios.set(index, new Usuario(txtNombre.getText(), txtCorreo.getText(), txtContrasena.getText()) {
					public String mostrarinfo() {
						return "Usuario: " + getNombre() + " | Correo: " + getCorreo();
					}
				});
			}
			JOptionPane.showMessageDialog(this, "Usuario editado");
		});
	}

	public static void main(String[] args) {
		MainApp app = new MainApp();
		app.setVisible(true);
	}
}