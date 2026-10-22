

public abstract class Administrador extends Usuario {

	private String nivelAcceso;

	public Administrador(String nombre, String correo, String contrasena, String nivelAcceso) {
		super(nombre, correo, contrasena);
		this.nivelAcceso = nivelAcceso;
	}

	public String getNivelAcceso() {
		return nivelAcceso;
	}
}