package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Node {
	private int content;
	private Node next;
	
	/**
	 * Pre: ---
	 * Post: Metodo constructor para el objeto respectivo
	 */
	public Node (int content) {
		this.content = content;
	}
	
	/**
	 * Pre: ---
	 * Post: Metodo constructor para el objeto respectivo
	 */
	public Node (int content, Node next) {
		this.content = content;
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * Pre: ---
	 * Post: Metodo toString devuelve las variables en un formato para
	 * ser mostrado por pantalla
	 */
	@Override
	public String toString() {
		return "Content = " + content + " Next = " + next;
	}

	
}
