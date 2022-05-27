package ejercicio4;

public class Recursivo {
	/**
	 * Pre: ---
	 * Post: Este es un metodo recursivo, que muestra por pantalla la tabla de multiplicar
	 * de los numeros pares hasta el 100
	 */
	public static int tablaMultiplicar(int i, int j) {
			if(i > 10) {
				i = 0;
				j = j + 2;
				if(j > 100) {
					return 0;
				}
			}
			System.out.println(j + " * " + i + " = " + j*i);
			return tablaMultiplicar(i + 1, j);
	}
	
	/**
	 * Pre: ---
	 * Post: Metodo main, hace la llamada al metodo recursivo 
	 * tablaMultiplicar()
	 */
	public static void main(String[] args) {
		tablaMultiplicar(0, 0);
	}
}
