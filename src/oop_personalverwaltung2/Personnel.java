package oop_personalverwaltung2;

/**
 * This class is used for building Personnel-objects
 * It also contains the compare-method which is used to sort the pers_arr-array by comparing the surname
 */
public class Personnel implements Comparable<Personnel> {
	
	//Instanzvariable
	private String forename;
	private String surname;
	private String entrydate;
	
	//Constructor
	Personnel(String forename, String surname, String entrydate){
		this.forename = forename;
		this.surname = surname;
		this.entrydate = entrydate;
	}

	//methods
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return this.forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getEntrydate() {
		return this.entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}
	
	public String getFullName() {
		String fullname = this.forename + " " + this.surname;
		return fullname;
	}
	
	//compareTo method
	@Override
	public int compareTo(Personnel p) {
		return this.getSurname().compareToIgnoreCase(((Personnel) p).getSurname());
	}
	
	
	

}
