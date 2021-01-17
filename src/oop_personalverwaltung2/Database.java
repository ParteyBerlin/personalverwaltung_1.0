package oop_personalverwaltung2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Database {
	
	// build personnel-Array
	static Personnel[] pers_arr = new Personnel[50];
	static Scanner scn = new Scanner(System.in);
	
	/**this method adds a person to the database
	 * for-loop checks every Pocket of the array for space left in the pers_arr-array, if there is free space a new entry will be added 
	 * if the array is full, the user will be notified
	 */
	
	public void addPers(Personnel newPers) {		
		for(int i=0; i<pers_arr.length;i++) {
			
			if(this.pers_arr[i] == null) {
				this.pers_arr[i] = newPers;
				break;
			}
			else if(this.pers_arr[pers_arr.length-1] != null) {
				System.out.println("Kann keine Mitarbeiter anlegen. Datenbank voll!");
			}
		}		
	} // end of addPers()
	
	/**this method is used to search for existing entries, by giving in the surname
	 * for-loop checks every element of the array for the wanted surname
	 * if the name was found, output will be full name and entry date of personnel
	 * if the name wasn´t found, user will be notified
	 */ 
	public void search() {
		System.out.println("Bitte Nachnamen eingeben");
		String surname = scn.next();
		
		for(int i=0; i<pers_arr.length; i++) {
			if(this.pers_arr[i] != null) {
				if(this.pers_arr[i].getSurname().equalsIgnoreCase(surname)) {
				System.out.println("\nGesuchter Mitarbeiter: " + this.pers_arr[i].getFullName() + " -- beschäftigt seit: " + this.pers_arr[i].getEntrydate() + "\n");
				break;
				}
			}
			else {
				System.out.println("\nMitarbeiter nicht in der Datenbank\n");
				break;
			}
		}
	}// end of search()
	
	
	/**
	 * this method shows a list of all personnel existing in the database
	 * first check will be if there are any entries in the pers_array-array
	 * if there are no entries, the user will get a notification
	 * if there are entries a temporary personnel object will be created
	 * next the pers_arr-array will be sorted alphabetically by comparing one entry in pers_arr-array to the following and put them in the right order
	 * blank elements will be terminated ( for-loops / temporary object / compareToIgnoreCase )
	 */
	public void showAll(){
	if(pers_arr != null) {	
	    Personnel temp;
	    for(int i=1; i< pers_arr.length; i++) {
	        for(int j=0; j< pers_arr.length-i; j++) {
	            if (pers_arr[j] == null && pers_arr[j + 1] != null)  {
	                pers_arr[j]=pers_arr[j+ 1];
	                pers_arr[j + 1]=null;
	                }
	                else if (pers_arr[j] != null && pers_arr[j + 1] != null){
	                    if(pers_arr[j].getSurname().compareToIgnoreCase(pers_arr[j+1].getSurname()) > 0) {
	                        temp=pers_arr[j];
	                        pers_arr[j]=pers_arr[j+ 1];
	                        pers_arr[j + 1]=temp;
	                        }
	                    }
	            }
	        }
	/**
	 * after sorting, pers_arr will be iterated to get and show the names of all Personnel
	 * to get the number of Personnel the x-variable works as a counter, which is incremented for every found personnel
	 * if the counter stays x == 0 the user gets a notification, that there is no entry for any personnel
	 * else the user gets a message, notifying how many personnel can be entered in the database
	 */
	if(pers_arr != null) {		
		int x = 0;
		for(int i=0; i<this.pers_arr.length;i++) {
				if(this.pers_arr[i] != null) {
					System.out.println("Mitarbeiter #" +(i+1) +": " + this.pers_arr[i].getFullName());
					x++;
				}
		}
			if(x == 0) {
				System.out.println("Keine Mitarbeiter eingetragen / Sie können noch " +this.pers_arr.length+ " Mitarbeiter eingetragen werden");			
			}
			else {
				int freeslots = this.pers_arr.length -x;
				System.out.println("\nEs können noch " + freeslots + " Mitarbeiter eingetragen werden\n");
			}
		}
	}
	else {
		System.out.println("Keine Mitarbeiter eingetragen\n\n");
	}
	} //end of showAll()
	
	
	/**
	 * this method is used to delete entries from database
	 * to prevent unintentionally delete the user is asked to give both, forename and surname of the personnel to delete
	 * next pers_arr-array will be checked if there are any entries
	 * if there are entries the method will iterate the pers_arr-array, if the name was found persCheck-counter will increase
	 * user is asked to confirm the delete
	 * if the names were not found, persCheck-counter will not increase, there will be a notification, that that personnel wasn't found in database
	 */
	
	public void delete() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Mitarbeiter aus der Datenbank entfernen");
		System.out.println("---------------------------------------");
		System.out.println("Bitte Nachnamen eingeben: ");
		String delSurname = scn.next();
		System.out.println("Bitte Vornamen eingeben: ");
		String delForename = scn.next();	
		
		int persCheck =0;
		for(int i=0;i<this.pers_arr.length;i++) {
			if(this.pers_arr[i] != null) {			
				if(this.pers_arr[i].getSurname().equalsIgnoreCase(delSurname) &&
				   this.pers_arr[i].getForename().equalsIgnoreCase(delForename)){
						persCheck++;
						String delname = pers_arr[i].getFullName();
						System.out.println("Mitarbeiter " + delname + " wirklich entfernen  J/N");
						String safeDel = scn.next();
						if(safeDel.equalsIgnoreCase("j")) {
							this.pers_arr[i] = null;
							System.out.println("Mitarbeiter " + delname + " entfernt\n");
							break;
						}
						else {
							System.out.println("Mitarbeiter " + delname + " nicht entfernt\n");
							break;
						}
				} // end of second if			
			} // end of first if
		} // end of forLoop
		if (persCheck == 0){
			System.out.println("Mitarbeiter nicht in der Datenbank!");
	} // end of delete()
	}
}
