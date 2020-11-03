
public class Libro {
	
	private String codigo;
	private String categoria;
	private String nombre;
	private int ancho;
	private boolean estado;
	
	//constructor
	public Libro(String codigo, String categoria, String nombre, int ancho){
		if(ancho<1 || ancho>200) {
			throw new RuntimeException("El ancho del libro debe ser mayor a 0 y menor o igual a 200");
		}
		this.codigo = codigo;
		this.categoria = categoria;
		this.nombre = nombre;
		this.ancho = ancho;
		this.estado = false;
	}
	
	//getters and setters
	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public int getAncho() {
		return this.ancho;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void setEstado(Boolean b) {
		this.estado = b;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [codigo= ");
		builder.append(this.codigo);
		builder.append(", categoria= ");
		builder.append(this.categoria);
		builder.append(", nombre= " );
		builder.append(this.nombre);
		builder.append(", ancho= ");
		builder.append(this.ancho);
		builder.append("]");
		return builder.toString();
	}
}
