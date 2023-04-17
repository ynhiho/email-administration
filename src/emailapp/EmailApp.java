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
				email.generateUserInformation(scanner);
				
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
	
		
}


