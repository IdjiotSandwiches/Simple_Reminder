package data;

import java.util.*;
import java.text.DateFormatSymbols;

public class Remind {
	String reminder, deadline;
	int id;
	
	Scanner sc = new Scanner(System.in);
	
	public Remind(int id){
		
		this.id = id;
		this.reminder = input_reminder();
		this.deadline = deadline();
		
	}
	
	private String input_reminder() {
		
		boolean check_length = false;
		String reminder = null;
		
		do {
			
			System.out.print("Input reminder [5-25 characters] : ");
			reminder = sc.nextLine();
			
			int length = reminder.length();
			
			if(length < 5 || length > 25) 
				System.out.println("Reminder name length must 5-25 characters!");
			else
				check_length = true;
			
		} while(check_length == false);
		
		return reminder;
		
	}
	
	private String input_month() {
		
		String month = null;
		boolean check_month = false;
		
		do {
			
			System.out.print("Input reminder Month [E.g : January |"
					+ " February | October (Case Sensitive)] : ");
			month = sc.nextLine();
			
			String[] month_list = new DateFormatSymbols().getMonths();
			int size = month_list.length;
			
			for(int i = 0; i < size; i++) {
				if(month_list[i].equals(month)) {
					check_month = true;
					break;
				}
			}
			
			if(check_month == false) {
				System.out.println("Please input month name in English (Case Sensitive)");
			}
			
		} while(check_month == false);
		
		return month;
		
	}
	
	private int input_date() {
		
		String date_string = null;
		boolean check_date = false;
		int date_int = 0;
		
		do {
			
			System.out.print("Input reminder Date [1-30]: ");
			date_string = sc.nextLine();
			
			if(!date_string.matches("[0-9]+"))
				System.out.println("Please input numeric value");
			else {
				date_int = Integer.parseInt(date_string);
				if(date_int < 1 || date_int > 30)
					System.out.println("Please input date value between 1 - 30");
				else
					check_date = true;
			}
			
			
		} while(check_date == false);
		
		return date_int;
	}
	
	private String deadline() {
		
		String month = input_month();
		String date =  String.valueOf(input_date());
		
		String deadline = date + " " + month;
		
		return deadline;
		
	}
}
