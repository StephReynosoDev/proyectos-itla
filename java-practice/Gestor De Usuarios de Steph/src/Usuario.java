

// la clase abstracta usuario con sus atributos
public abstract class Usuario {
	private String nombre;
	private String correo;
	private String contrasena;
	
	// mi contructor dandole su set con los this.
	public Usuario (String nombre, String correo, String contrasena) {
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public String getCorreo() {
		return correo;
		
	}
	
	public String getContrasena() {
		return contrasena;
		
	}
	
	
	
	
	
	
	public abstract String mostrarinfo(); 
		
		
	
	
	
	
	
	
	
	
	
	

}
