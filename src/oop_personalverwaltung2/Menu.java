package oop_personalverwaltung2;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Admin
 * This class shows the menu and is used to build new personnel-objects
 */


public class Menu {
	static int choice;
	
	public static void menu() {
		Scanner scn = new Scanner(System.in);
		Database db = new Database();
		
		//usermenu
		System.out.println("Personalverwaltung");
		System.out.println("------------------");
		System.out.println("1:\tMitarbeiter anlegen");
		System.out.println("2:\tMitarbeiter suchen");
		System.out.println("3:\tAlle Mitarbeiter anzeigen");
		System.out.println("4:\tMitarbeiter löschen");
		System.out.println("\n5:\tProgramm beenden");
		
		//try and catch - to make sure the user enters an Integer-value
		try {
				choice = scn.nextInt();
		}catch (Exception e) {
            System.out.println("FEHLER");;
        }
		
		/**
		 * switch-case : used to add, search, show all and to delete personnel and to terminate the program
     	 */
		switch(choice) {
		case 1:
				db.addPers(newPers());
				break;
		case 2:
				db.search();
				break;
		case 3:
				db.showAll();
				break;
		case 4:
				db.delete();
				break;
		case 5:
				System.out.println("Programm beenden? J/N");
				String exit = scn.next();
				if(exit.equalsIgnoreCase("j")) {
					System.out.println("Programm beendet");
					System.exit(0);
				}
				else {
					//System.out.println("");
					promptEnterKey();
					break;
				}			
		case 9:
				System.out.println("\n----------------------------");
				System.out.println("0STEREI gefunden. Congrats !");
				System.out.println("----------------------------\n");
		
		default:
				System.out.println("\nFalsche Eingabe\n");		
		}		
	}
	/**
	 * method newPers() builds and returns a personnel-object
	 */
	public static Personnel newPers() {
		Scanner scn = new Scanner(System.in);
			System.out.println("Vornamen eingeben:");
			String forename = scn.next();
			System.out.println("Nachname eingeben:");
			String surname = scn.next();
			System.out.println("Einstellungsdatum eingeben");
			String entrydate = scn.next();
			Personnel pers = new Personnel(forename , surname , entrydate);
			return pers;
	}
	
	/**
	 * method promptEnterKey() is used to pause the program until user hits ENTER
	 */
	public static void promptEnterKey(){
	    System.out.println("\n\n \"ENTER\" um fortzufahren...");
	    try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
