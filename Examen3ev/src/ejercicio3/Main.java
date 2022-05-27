package ejercicio3;

public class Main {
	public static void main(String[] args) {
		SimpleLinkedList s = new SimpleLinkedList();
		s.add(new Node(1));
		s.add(new Node(3));
		s.add(new Node(20));
		s.add(new Node(12));
		s.add(new Node(55));
		s.eliminarMayor();
		s.show();
	}
}
