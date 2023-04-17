package emailapp;
import java.util.Scanner;
import java.util.ArrayList;

public class EmailApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		Email email= new Email();
		
		while (!exit) {
		
			System.out.print("Hello! Welcome to the administration system of CompanyXYZ. What do you want to do next?\nPress a number\n1 = create new email adress\n2 = change password\n3 = show my email\n4 = exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			
			if(choice == 1) {
				email = generateEmailAdress(scanner);
			} else if(choice == 2) {
				email.changePassword(scanner);
				
			} else if(choice == 3) {
				email.displayEmail(scanner);
				
			} else if(choice == 4) {
				exit = true;
				
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
			
		}
		scanner.close();
	
	}
	
	private static Email generateEmailAdress(Scanner scanner) {
		
		
		System.out.print("Enter your firstname: ");
		String firstname = scanner.nextLine();
		
		System.out.print("Enter your lastname: ");
		String lastname = scanner.nextLine();
		
		System.out.print("What is your department? Press 1 = sales, 2 = development, 3 = accounting, 4 = none: ");
		int departmentNumber = scanner.nextInt();
		scanner.nextLine();
		
		String department = "";

		switch (departmentNumber) {
	    case 1:
	    	department = "sales";
	        break;
	    case 2:
	    	department = "development";
	        break;
	    case 3:
	    	department = "accounting";
	        break;
	    case 4:
	    	department = "none";
	        break;
		}
		
		Email email = new Email(firstname, lastname, department);
		
		System.out.println("\nWelcome " + email.getName() + " to the team!");
		System.out.println("Your new email adress is: " + email.getEmailAdress());
		System.out.print("A new password has been generated for you: " + email.getPassword()+ "\n");
	
		
		return email;
		
	}
		
}


