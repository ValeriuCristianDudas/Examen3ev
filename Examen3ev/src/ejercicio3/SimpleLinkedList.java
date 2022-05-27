package ejercicio3;


public class SimpleLinkedList {
	private Node first;
	private int size;
	
	public SimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public SimpleLinkedList(Node first) {
		this.first = first;
		this.size = 1;
	}
	
	public SimpleLinkedList (Node first, int numeroNodos) {
		this.first = first;
		size = numeroNodos;
	}

	public Node getFirst() {
		return first;
	}
	
	public void setFirst(Node first) {
		this.first = first;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean eliminarMayor() {
		Node p = first;
		int m = 0;
		int pos = 0;
		for(int i = 0; i > size; i++) {
			if(i == 0) {
				pos = 0;
				m = p.getContent();
			} else {
				if(m < p.getContent()) {
					pos = i;
					m = p.getContent();
				}
			}
			if(i == size - 1) {
				delete(pos);
			} else {
				p = p.getNext();
			}
		}
		return false;
		
		
	}
	public boolean delete(int position) {
		try {
			if (position == 0) {
				if(size == 1) {
					first = null;
					size--;
				} else {
					first = first.getNext();
					size--;
				}
			} else if (position == size) {
				Node p = first;
				for (int i = 1; i < size - 1; i++) {
					p = p.getNext();
				}
				size--;
			} else {
				Node p = first;
				for (int i = 1; i < position - 1; i++) {
					p = p.getNext();
				}
				p.setNext(p.getNext().getNext());
				size--;
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add (Node node) {
		try {		
			if (size == 0) {
				first = node;
			} else {
				Node p = first;
				for (int i = 1; i < size; i++) {
					p = p.getNext();
				} 
				p.setNext(node);
			} size++;
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add (int position, Node node) {
		try {
			if (position == 0) {
				node.setNext(first);
				first = node;
			} else if (position == size) {
				return (add(node));
			} 	
			else {
				Node p = first;
				for (int i = 1; i < position; i++) {
					p = p.getNext();
				}
				node.setNext(p.getNext());
				p.setNext(node);
			} size++; return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	} 
	
	public void show() {
		Node p = first;
		for (int i = 0; i < size; i++) {
			System.out.println("[" + i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}
}
