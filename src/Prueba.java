public class Prueba {

	public static void main(String[] args) {
		

		
		BDUNGS bd = new BDUNGS(10, 100);
		bd.rotularEstante("Computacion", 1);
		bd.rotularEstante("Matematica", 2);
		bd.ingresarLibro("9789684443457", "Computacion", "Estructuras de datos", 5);
		bd.ingresarLibro("9788415552222", "Computacion", "Estructuras de datos en Java", 7);
		bd.ingresarLibro("9389557783457", "Matematica", "Analisis de Funciones", 4);
		System. out .println(bd);
		bd.eliminarLibro("9389557783457");
		bd.rotularEstante("Analisis Matematico", 2);
		System. out .println(bd);
		
//		BDUNGS bd = new BDUNGS(8, 30);
		
//		bd.rotularEstante("Computacion", 1);
//		bd.rotularEstante("Matematica", 2);
//		bd.ingresarLibro("9789684443457", "Computacion", "Estructuras de datos", 5);
//		bd.ingresarLibro("9788415552222", "Computacion", "Estructuras de datos en Java", 7);
//		bd.ingresarLibro("9389557783457", "Matematica", "Analisis de Funciones", 4);
//		System. out .println(bd);
//		bd.eliminarLibro("9389557783457");
//		bd.rotularEstante("Analisis Matematico", 2);
//		System. out .println(bd);
//		System.out.println(bd.reacomodarCategoria("Computacion"));

//		bd.rotularEstante("Computacion", 1);
//		bd.ingresarLibro("1", "Computacion", "Estructuras de datos y algoritmos", 5);
//		bd.ingresarLibro("2", "Computacion", "Estructuras de datos en Java", 25);
//		
//		bd.rotularEstante("Computacion", 2);
//		bd.ingresarLibro("3", "Computacion", "Base de datos I", 5);
//		bd.ingresarLibro("4", "Computacion", "Base de datos II", 5);
//		bd.ingresarLibro("5", "Computacion", "Base de datos II", 20);
//		
//		bd.rotularEstante("Computacion", 3);
//		bd.ingresarLibro("6", "Computacion", "Programacion C++", 5);
//		bd.ingresarLibro("7", "Computacion", "Programacion C++", 5);
//		bd.ingresarLibro("8", "Computacion", "Programacion C++", 5);
//		bd.ingresarLibro("9", "Computacion", "Programacion C++", 15);
//		bd.eliminarLibro("2");
//		bd.eliminarLibro("5");
//		bd.eliminarLibro("9");
		
//		bd.rotularEstante("Computacion", 1);
//		bd.ingresarLibro("1", "Computacion", "Estructuras de datos y algoritmos", 5);
//		bd.ingresarLibro("2", "Computacion", "Estructuras de datos y algoritmos", 5);
//		bd.ingresarLibro("3", "Computacion", "Estructuras de datos y algoritmos", 5);
//		bd.ingresarLibro("4", "Computacion", "Estructuras de datos y algoritmos", 15);
//		
//		bd.rotularEstante("Computacion", 2);
//		bd.ingresarLibro("5", "Computacion", "Estructuras de datos y algoritmos", 5);
//		bd.ingresarLibro("6", "Computacion", "Estructuras de datos y algoritmos", 5);
//	
//		bd.eliminarLibro("4");
//		
//		System. out .println(bd);
//		
//		System.out.println(bd.reacomodarCategoria("Computacion"));
//		System.out.println(bd.verLibrosCategoria("Computacion"));
//		System. out .println(bd);
	}
}
