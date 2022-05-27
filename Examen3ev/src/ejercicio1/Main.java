package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	/**
	 * Pre: ---
	 * Post: ---
	 */
	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();
		dao.readDataBase();
		File f = new File("HablanosDelDon.txt");
		lecture(f);
	}
	
	/**
	 * Pre: ---
	 * Post: ---
	 */
	public static void lecture(File f) {
		try {
			Scanner l = new Scanner(f);
			while(l.hasNextLine()) {
				String li = l.nextLine();
				li = li.replace(".", "").replace("?", "").replace("¿", "")
						.replace(",", "");
				String[] line = li.split(" ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}