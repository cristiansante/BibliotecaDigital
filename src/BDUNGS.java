import java.util.ArrayList;
import java.util.HashMap;

public class BDUNGS {
	
	private int cantidadEstantes;
	private int anchoEstante;
	private int numeroDeOrden;
	
	private HashMap<String, ArrayList<Estante>> biblioteca = new HashMap<String, ArrayList<Estante>>();
	private ArrayList<Estante> estantes;
		
	//constructor
	public BDUNGS(int cantidadEstantes, int ancho) {
		this.cantidadEstantes = cantidadEstantes;
		this.anchoEstante = ancho;
		this.numeroDeOrden = 1;
		this.estantes = new ArrayList<Estante>();
		//creamos los estantes predefinidos		
		for(int i = 0; i < cantidadEstantes; i++) {
			Estante n= new Estante("",ancho);
			n.setNumeroEstante(this.numeroDeOrden);
			this.estantes.add(n);			
			this.numeroDeOrden++;
			
		}	
	}

	public void ingresarLibro(String codigo, String categoria, String nombre, int ancho) {

		if(ancho<this.anchoEstante) {
			
			boolean flag = false;
						
			if(this.biblioteca.containsKey(categoria)){
				
				//caso 1: si encuentra un estante con su categoria y ademas hay espacio disponible
				for(Estante estante : this.biblioteca.get(categoria)){
					
					if(ancho<=estante.getEspacioLibre()) {
						estante.ingresarLibro(codigo, categoria, nombre, ancho);
						flag = true;
						break;
					}
				}
				//caso 2: si el estante esta vacio lo rerotula y despues agrega
				if(flag == false){			
					
					rotularEstantePrivado(categoria, this.numeroDeOrden);			
					
					for(Estante estante : this.biblioteca.get(categoria)){
						
						if(ancho<=estante.getEspacioLibre()) {
							estante.ingresarLibro(codigo, categoria, nombre, ancho);
							flag = true;
							break;
						}
					}
				}					
				//caso 3: si entro aca es porque no hay estantes con esa categoria ni tampoco alguno para rotular
				if(flag == false) {
					
					rotularEstantePrivado(categoria, this.numeroDeOrden);
						
						for(Estante estante : this.biblioteca.get(categoria)){
								
							if(estante.estaVacio()) {				
								estante.ingresarLibro(codigo, categoria, nombre, ancho);								
								break;
							}
						}		
				}
			}
			else {
				throw new RuntimeException("La categoria no existe. Por favor rotule algun estante");
			}
			
		}
		else {
			throw new RuntimeException("El ancho del libro es mayor que el ancho del estante");
		}	
	}

	public void rotularEstante(String categoria, Integer ubicacion) {
		
		//guardo estos valores para despues eliminar del hashmap
		String categoriaAux; 
		int num;
		
		//se resta uno porque en el arraylist de estantes las posiciones empiezan desde cero
		if(ubicacion<this.cantidadEstantes && ubicacion>0) {
			
			//caso 1: el estante esta vacio entonces se rotula (mejor caso usuario)
			if(this.estantes.get(ubicacion-1).estaVacio()) {
				
				//si el estante es uno de los predefinidos en el constructor:
				if(this.estantes.get(ubicacion-1).getCategoria().equals("")) {
					if(this.estantes.get(ubicacion-1).estaVacio()) {
						this.estantes.get(ubicacion-1).setCategoria(categoria);
						//si la categoria no existe en el hash la creamos
						if(!this.biblioteca.containsKey(categoria)) {
							this.biblioteca.put(categoria, new ArrayList<Estante>());
						}
						this.biblioteca.get(categoria).add(this.estantes.get(ubicacion-1));
					}
					
				}
				//si el estante ya fue usado por alguna categoria:
				else {
					//guardo en un aux la categoria y el numero de orden
					categoriaAux = this.estantes.get(ubicacion-1).getCategoria();
					num = this.estantes.get(ubicacion-1).getNumeroEstante();
					
					this.estantes.get(ubicacion-1).setCategoria(categoria);
					
					if(!biblioteca.containsKey(categoria)) {
						this.biblioteca.put(categoria, new ArrayList<Estante>());
					}
					this.biblioteca.get(categoria).add(this.estantes.get(ubicacion-1));
					
					//si la categoriaAux existe busco el estante que "movi" para eliminarlo
					if(biblioteca.containsKey(categoriaAux)) {
						for(int i=0;i<this.biblioteca.get(categoriaAux).size();i++){
							if(this.biblioteca.get(categoriaAux).get(i).getNumeroEstante()==num) {
								this.biblioteca.get(categoriaAux).remove(i);
							}		
						}
					}
				}
			}
			else {
				throw new RuntimeException("El estante no esta vacio");
			}
		}
		else {
			throw new RuntimeException("no existe esa ubicacion");
		}
	}
	
	private void rotularEstantePrivado(String categoria, Integer ubicacion) {
		
		boolean flag = false;
		
		//caso 1: todos los estantes estan ocupados: se crea uno nuevo
		if(ubicacion>this.cantidadEstantes) {
			
			Estante nuevo = new Estante(categoria, this.anchoEstante);
			if(this.biblioteca.containsKey(categoria)) {
				
				nuevo.setNumeroEstante(numeroDeOrden);
				this.estantes.add(nuevo);
				this.biblioteca.get(categoria).add(nuevo);
				this.numeroDeOrden++;
				this.cantidadEstantes++;
				flag = true;
			}		
		}
		//caso 2: hay un estante vacio en los predefinidos. Rotulo y agrego.
		if(flag == false) {
			for(int i=0;i<this.estantes.size();i++) {
				if(this.estantes.get(i).getCategoria().equals("")) {
					this.estantes.get(i).setCategoria(categoria);
					this.biblioteca.get(categoria).add(this.estantes.get(i));
					flag=true;
					break;					
				}
			}
		}	
		//caso 3: si estan todos los estantes llenos tengo que fijarme si hay alguno vacio de otra categoria para rerotular
		if(flag == false) {
			
			String categoriaAux="";
			int numeroEstanteAux=0;
			
			for(int i=0;i<this.estantes.size();i++) {
					if(this.estantes.get(i).estaVacio()) {
						categoriaAux = this.estantes.get(i).getCategoria();
						numeroEstanteAux = this.estantes.get(i).getNumeroEstante();
						this.estantes.get(i).setCategoria(categoria);
						this.biblioteca.get(categoria).add(estantes.get(i));
						break;
					}
			}
			this.biblioteca.get(categoriaAux).remove(numeroEstanteAux);			
		}									
	}

	public void eliminarLibro(String codigo) {
		//recorro estante por estante desdee el arraylist
		for(int i=0;i<this.estantes.size();i++) {
			this.estantes.get(i).eliminarLibro(codigo);
		}		
	}

	public double espacioLibre(int ubicacion) {
		
		if(ubicacion>this.cantidadEstantes || ubicacion<1) {
			throw new RuntimeException("esta ubicacion no existe");
		}		
		if(this.estantes.get(ubicacion-1).getCategoria()=="") {
			throw new RuntimeException("este estante no tiene categoria");
		}
		return this.estantes.get(ubicacion-1).getEspacioLibre();
	}
	
	public HashMap<String, Integer> verLibrosCategoria(String categoria) {
		
		HashMap<String, Integer> librosMismaCategoria = new HashMap<String,Integer>();
				
		if(this.biblioteca.containsKey(categoria)) {
			for(Estante estante : this.biblioteca.get(categoria)){
				for(int i=0;i<estante.getLibros().size();i++) {
					if(librosMismaCategoria.containsKey(estante.getLibros().get(i).getCodigo())) {
						librosMismaCategoria.put(estante.getLibros().get(i).getCodigo(),librosMismaCategoria.get(estante.getLibros().get(i).getCodigo())+1);
					}
					else {
						librosMismaCategoria.put(estante.getLibros().get(i).getCodigo(), 1);
					}
				}				
			}
		}
		else {
			throw new RuntimeException("No existe la categoria");
		}
		return librosMismaCategoria;
	}

	public int reacomodarCategoria(String categoria) {
		
		int estantesliberados=0;
		int cont=0;
		
		for(int i=biblioteca.get(categoria).size()-1; i>cont ;i--){
			Estante primero=biblioteca.get(categoria).get(cont);
			Estante ultimo=biblioteca.get(categoria).get(i);
			estantesliberados=estantesliberados+moverlibro(primero,ultimo);
			
			if(primero.estaVacio() || primero.estaLleno()){
				cont+=1;
				i++;
			}	
		}		
		return estantesliberados;	
	}
	
	public int moverlibro(Estante primero,Estante ultimo){//este metodo mueve los libros al estante mas lleno y devuelve si alguno quedo vacio
	
		int cont=0;
		int vacio=0;

		if(primero.estaVacio()||ultimo.estaLleno()){
			vacio++;
		}
		
		if(primero.getEspacioLibre() <= ultimo.getEspacioLibre()){
			for (int i=0;i<ultimo.getLibros().size();i++){
				if(primero.getEspacioLibre()>=ultimo.getLibros().get(i).getAncho()){
					primero.ingresarLibro(ultimo.getLibros().get(i).getCodigo(),ultimo.getLibros().get(i).getCategoria(),ultimo.getLibros().get(i).getNombre() ,ultimo.getLibros().get(i).getAncho() );
					ultimo.eliminarLibro(ultimo.getLibros().get(i).getCodigo());
					i--;
				}
			}
		}
		else{		
			for (int i=0;i<primero.getLibros().size();i++){
				if(ultimo.getEspacioLibre()>=primero.getLibros().get(i).getAncho()){
					ultimo.ingresarLibro(primero.getLibros().get(i).getCodigo(),primero.getLibros().get(i).getCategoria(),primero.getLibros().get(i).getNombre() ,primero.getLibros().get(i).getAncho() );
					primero.eliminarLibro(primero.getLibros().get(i).getCodigo());
					i--;
				}
			}
		}
		if(primero.estaVacio()||ultimo.estaVacio()){
			cont+=1;
		}
		
		return cont-vacio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BDUNGS [Cantidad de Estantes= ");
		builder.append(this.cantidadEstantes);
		builder.append(", Ancho de los estantes= ");
		builder.append(this.anchoEstante);
		builder.append(", Estantes= ");
		builder.append(this.biblioteca);
		builder.append("]");
		return builder.toString();
	}
}
