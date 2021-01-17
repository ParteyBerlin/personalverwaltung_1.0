package oop_personalverwaltung2;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		/**
		 * To-Do: Add function to delete the entire database at once
		 */
		//create Database object
		Database db = new Database();
		Scanner scn = new Scanner(System.in);
		
		/**
		 * loops the menu() method in Menu.java until user enters a valid input
		 */
		boolean menuLoop = true;
		while(menuLoop) {
			Menu.menu();
		}
		

	}

}
