package main;

import java.util.Scanner;

import model.List;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static List list = new List();
	
	public static void main(String[] args) {
		
		System.out.println("Select the option:\n");
		System.out.println("1. Give turn\n");
		System.out.println("2. Show turn\n");
		System.out.println("3. pass turn\n");
		System.out.println("4. Delete actual turn\n");
		
		int op = -1;
		while(op!=0) {
			op=showMenu();
			options(op);
		}
	}
	private static void options(int num) {
		switch(num) {
			case 1:
				giveTurn();
				break;
			case 2:
				showTurn();
				break;
			case 3:
				passTurn();
				break;
			case 4:
				deleteActualTurn();
				break;
		}
		
	}

	private static void giveTurn() {
		list.add();
		System.out.println("The turn has been asigned\n");
	}

	private static void showTurn() {
		System.out.println("The next turn is \n");
		list.print();
		
	}

	private static void passTurn() {
		System.out.println("The turn has been passed to the tail\n");
		list.passTurn();
	}

	private static void deleteActualTurn() {
		boolean del = list.deleteActualTurn();
		if(del) {
			System.out.println("The turn has been delete correctly\n");
		}else {
			System.out.println("The turn couldn't be deleted\n");
		}
		
	}
	private static int showMenu() {
		int out = sc.nextInt();
		sc.nextLine();
		while(out>4||out<1) {
			System.out.println("This option is not valid, type the correct option");
			out=sc.nextInt();
			sc.nextLine();
		}
		return out;
	}

}
