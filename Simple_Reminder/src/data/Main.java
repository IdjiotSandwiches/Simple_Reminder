package data;

import java.util.*;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Vector<Remind> reminder = new Vector<>();
	static int id = 0;
	
	public static void main(String[] args) {
		cls();
		int input;
		
		do {
			
			input = main_menu();
			
			switch(input) {
				case 1:
					++id;
					reminder.add(new Remind(id));
					System.out.println("Reminder added!");
					press_enter();
					break;
				case 2:
					view_reminder();
					press_enter();
					break;
				case 3:
					sc.close();
					reminder.clear();
					System.exit(0);
					break;
			}
			
		} while(input != 3);
		
	}
	
	static int main_menu() {
		int input;
		
		do {
			
			System.out.println("Welcome to Reminder App!");
			
			for(int i = 0; i < 20; i++) {
				System.out.print("=");
			}
			System.out.println();
			
			System.out.println("1. Add Reminder");
			System.out.println("2. View Reminder");
			System.out.println("3. Exit");
			System.out.print(">> ");
			input = sc.nextInt();
			
			if(input >= 1 && input <= 3)
				return input;
			else {
				System.out.println("Invalid value![1-3]...");
				press_enter();
			}
			
		} while(true);
		
	}
	
	static void view_reminder() {
		if(reminder.isEmpty()) {
			System.out.println("Reminder Empty");
			return;
		}
		else {
			System.out.println("Reminder List");
			
			for(int i = 0; i < 13; i++) {
				System.out.print("=");
			}
			System.out.println();
			
			for(Remind reminder : reminder) {
				System.out.println(reminder.id + ". " + reminder.reminder + ", "
						+ reminder.deadline);
			}
			
			int input = 0;
			boolean check_condition = false;
			
			while(check_condition == false) {

				System.out.print("[Type reminder number to mark as done, or 0 to go back] : ");
				input = sc.nextInt();
				
				int length = reminder.size();
				
				if(input == 0)
					check_condition = true;
				else if(input < 0 && input > length)
					System.out.println("The number is invalid!");
				else {
					mark_as_done(input);
					System.out.println("Reminder successfully removed!");
					check_condition = true;
				}	
			}
		}
	}
	
	static void mark_as_done(int input) {
		reminder.remove(input - 1);
		id--;
		
		int length = reminder.size();
		
		for(int i = input - 1; i < length; i++) {
			reminder.get(i).id--;
		}
	}
	
	static void press_enter() {
		System.out.println();
		System.out.println("Press ENTER to continue...");
		sc.nextLine();
		sc.nextLine();
		System.out.println();
		cls();
	}
	
	static void cls() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
	
	
}
