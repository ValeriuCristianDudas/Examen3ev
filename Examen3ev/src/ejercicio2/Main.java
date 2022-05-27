package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
					li = li.replace(".", "");
					System.out.println(li);
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
							loc.add(new Localidad(line[0], line[3]));
						} else {
							
						}
					}
				}
			}
			System.out.println("El n�mero total de divorcios CON "
					+ "separaci�n previa en el a�o 2019: " + cdn);
			System.out.println("El n�mero total de divorcios SIN"
					+ " separaci�n previa en el a�o 2018: " + sdo);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
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
	
	public static void main(String[] args) {
		File f = new File("Divorcios.csv");
		lecture(f);
	}
}
