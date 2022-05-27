package ejercicio3;

public class Main {
	/**
	 * Pre:
	 * Post: Metodo main, crea una lista simple enlazada y añade nodos,
	 * luego llama a metodos de la clase SimpleLinkedList
	 */
	public static void main(String[] args) {
		SimpleLinkedList s = new SimpleLinkedList();
		s.add(new Node(1));
		s.add(new Node(3));
		s.add(new Node(20));
		s.add(new Node(12));
		s.add(new Node(55));
		s.add(new Node(10));
		s.eliminarMayor();
		s.show();
	}
}
