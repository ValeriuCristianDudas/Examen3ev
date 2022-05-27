package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	/**
	 * Pre:
	 * Post: Este metodo lee el fichero .csv y saca la informacion de el
	 */
	public static void lecture(File f) {
		ArrayList<Localidad> loc = new ArrayList<Localidad>();
		try {
			int cdn = 0;
			int sdo = 0;
			int c = 0;
			Scanner l = new Scanner(f);
			while(l.hasNextLine()) {
				if(c == 0) {
					String li = l.nextLine();
					c++;
				} else {
					String li = l.nextLine();
					li = li.replaceFirst(".", "");
					String[] line = li.split(";");
					if(line[1].equalsIgnoreCase("si")) {
						if(line[2].contains("2019")){
							++cdn;
						}
					} else if(line[1].equalsIgnoreCase("no")) {
						if(line[2].contains("2018")) {
							++sdo;
						}
					}
					if(loc.size() == 0) {
						if(isInteger(line[3])) {
							loc.add(new Localidad(line[0], Integer.parseInt(line[3])));
						} else {
							loc.add(new Localidad(line[0], 0));
						}
					} else {
						int s = loc.size();
						for(int i = 0; i < loc.size(); i++) {
							if(loc.get(i).getDenom().equalsIgnoreCase(line[0])) {
								if(isInteger(line[3])) {
									loc.get(i).setTotal(loc.get(i).getTotal() + Integer.parseInt(line[3]));
								}	
							} else {
								if(isInteger(line[3])) {
									loc.add(new Localidad(line[0], Integer.parseInt(line[3])));
								} else {
									loc.add(new Localidad(line[0], 0));
								}
								break;
							}
						}
					}
				}
			}
			
			//Ordena el Array
			Collections.sort(loc, new Comparator<Localidad>() {
				public int compare(Localidad a1, Localidad a2) {
					if (a1.getTotal() < a2.getTotal()) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			
			System.out.println("El n�mero total de divorcios CON "
					+ "separaci�n previa en el a�o 2019: " + cdn);
			System.out.println("El n�mero total de divorcios SIN"
					+ " separaci�n previa en el a�o 2018: " + sdo);
			System.out.println("La localidad con mas divorcios es: " + loc.get(0).toString());
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo comprueba si el String recibido se puede
	 * parsear a int
	 */
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	/**
	 * Pre: ---
	 * Post: Metodo main, crea el objeto tipo File y llama al metodo lecture()
	 * enviandole el File
	 */
	public static void main(String[] args) {
		File f = new File(".\\Divorcios.csv");
		lecture(f);
	}
}
