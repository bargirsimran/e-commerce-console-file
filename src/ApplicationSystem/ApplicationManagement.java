package ApplicationSystem;
import java.util.*;
import 	ProductManagement.ProductManagement;
import UserManagement.UserManagement;

public class ApplicationManagement {
	public static void main(String args[]) {
		
		System.out.println("****Welcome to Ecommerce Maanagement****");
		
		boolean shouldcontinue=true;
		Scanner sc=new Scanner(System.in);
		
		while(shouldcontinue) {
			System.out.println("What would you like to do?");
			System.out.println("1. Product Management\n2. User Management\n3. Exit");
			
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:ProductManagement.productManagement();
					break;		
					
			case 2:UserManagement.UserManagement();
				break;
			
			case 3: System.out.println("Exiting the application...");
					shouldcontinue=false;
					break;
					
			default:System.out.println("Exitting Application!!");
			}
			
		}
	}
}
