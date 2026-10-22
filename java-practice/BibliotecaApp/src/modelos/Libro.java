package modelos;

public class Libro extends DistribucionBiblioteca {
private String titulo;
private String autor;
private String genero;
private String descripcion;



public Libro (int id, String titulo, String autor, String genero, String descripcion){
	super(id);
	this.titulo = titulo;
	this.autor = autor;
	this.genero = genero;
	this.descripcion = descripcion;
	
}
	
	

	public String getTitulo() {
		return titulo;
	}
	
	
	
	public String getAutor() {
		return autor;
	}
	
	public String getGenero() {
		return genero;
	}
	

	public String getDescripcion() {
		return descripcion;
	}
	
	
	
	
	
	



















}

