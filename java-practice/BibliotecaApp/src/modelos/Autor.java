package modelos;

public class Autor extends DistribucionBiblioteca {
private String nombre;
private String nacionalidad;



public Autor(int id, String nombre, String nacionalidad) {
	super (id);
	this.nombre = nombre;
	this.nacionalidad = nacionalidad;
	
}

public String getNombre() {
	return nombre;
	
}



public String getNacionalidad() {
	return nacionalidad;
	
}
}

