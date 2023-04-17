package emailapp;
import java.security.SecureRandom;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String department;
	private String emailadress = "";
	
	private static ArrayList<Email> allInstances = new ArrayList<>();
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
	private static final int PASSWORDLENGTH = 10;
	private String password = "";
	
	public Email() {
		this.firstname = "UserFirstname";
		this.lastname = "UserLastname";
		this.department = "UserDepartment";
	}
	
	public Email (String firstname, String lastname, String department) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		allInstances.add(this);
		generateEmailAdress(firstname, lastname, department);
		generatePassword();
	}
	
	private void generateEmailAdress(String firstname, String lastname, String department) {
		emailadress = firstname + "." + lastname + '@' + department + ".company.com";
	}
	
	public void generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(PASSWORDLENGTH);
        for (int i = 0; i < PASSWORDLENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        
            this.password = sb.toString();
        }
	}
	
	public void changePassword(Scanner scanner) {
		System.out.print("What is your email adress? ");
		String useremail = scanner.nextLine();
		
		ArrayList<Email> allEmailInstances = Email.getAllEmails();
		Email matchedEmail = null;
		
		for (Email email : allEmailInstances) { 
			if (email.getEmailAdress().equals(useremail)) { 
					matchedEmail = email; break; 
			} 
		}
		 
		matchedEmail.generatePassword();
		System.out.print("You've set a new password. The new password is: " +
		matchedEmail.getPassword() + "\n");
	}
	
	public void displayEmail(Scanner scanner) {
		System.out.print("What is your firstname? ");
		String firstname = scanner.nextLine();
		
		System.out.print("Enter your lastname: ");
		String lastname = scanner.nextLine();
		
		ArrayList<Email> allEmailInstances = Email.getAllEmails();
		Email matchedEmail = null;
		
		for (Email x : allEmailInstances) {
		    if (x.getName().equals(firstname + " " + lastname)) {
		        matchedEmail = x;
		        break;
		    }
		}
		System.out.print("Hello " + firstname + " " + lastname + "!\nYour email adress is: " + matchedEmail.getEmailAdress() + "\n");
	}
	
	public String getName() {
		return firstname + " " + lastname;
	}
	
	public String getEmailAdress() {
		return emailadress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public static ArrayList<Email> getAllEmails(){
		return allInstances;
	}
	
	public void setNewPassword() {
		generatePassword();
	}
	
}
