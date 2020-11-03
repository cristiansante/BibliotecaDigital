import java.util.ArrayList;
import java.util.Iterator;

public class Estante {
	
	private String categoria;
	private ArrayList <Libro> libros;
	private double espacioLibre;
	private double espacioOriginal;
	private int numeroEstante;

	//constructor
	public Estante(String categoria, int ancho){
		
		if( ancho<1 || ancho>200) {
			throw new RuntimeException("El ancho de los estantes debe ser mayor a 0 y menor o igual a 200");
		}	
		this.categoria = categoria;
		this.espacioLibre = ancho;
		this.espacioOriginal = ancho;
		this.libros = new ArrayList<Libro>();
		this.numeroEstante = 1;		
	}
	
	public void ingresarLibro(String codigo, String categoria, String nombre, int ancho) {
		
		Libro nuevo = new Libro(codigo, categoria, nombre, ancho);
		
		this.libros.add(nuevo);
		//restamos el espacio del libro en el espacio libre para llevar el control
		this.espacioLibre = (this.espacioLibre-ancho);
	}
	
	public void eliminarLibro(String codigo) {
		
		int espacio;
		
		Iterator<Libro> it= libros.iterator();
		
		while(it.hasNext()) {
			Libro nombre= it.next();
			if (nombre.getCodigo().equals(codigo)) {
				espacio = nombre.getAncho();//lo usamos para llevar el control del espacio disponible
				it.remove();
				this.espacioLibre = this.espacioLibre + espacio;
			}
		}
	}
	
	public boolean estaVacio() {
		
		if(this.espacioLibre == this.espacioOriginal) {
		
			return true;
		}
		return false;
	}
	
	public boolean estaLleno() {
		
		if(this.espacioLibre==0) {
		
			return true;
		}
		return false;
	}
	
	//gettters and setters
	public String getCategoria() {
		
		return this.categoria;
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public double getEspacioLibre() {
		
		return this.espacioLibre;
	}

	public void setCategoria(String categoria) {
	
		this.categoria = categoria;
	}
	
	public int getNumeroEstante() {
		
		return this.numeroEstante;
	}
	public void setNumeroEstante(int ubicacion) {
		
		this.numeroEstante = ubicacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estante [categoria= ");
		builder.append(this.categoria);
		builder.append(", Numero de estante= ");
		builder.append(this.numeroEstante);
		builder.append(", Libros= ");
		builder.append(this.libros);
		builder.append(", Espacio Libre= ");
		builder.append(this.espacioLibre);
		builder.append(", Espacio Original= ");
		builder.append(this.espacioOriginal);
		builder.append("]");
		return builder.toString();
	}
}