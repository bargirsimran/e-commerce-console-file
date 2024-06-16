package UserManagement;
import java.util.*;
import java.io.*;

public class UserManagement {
	static List<String> UserListFromFile=new ArrayList<>();
	
	public static void UserManagement() {
		System.out.println("****Welcome to user management****");
		Scanner sc=new Scanner(System.in);
		
		boolean shallcontinue=true;
		
		User user=new User();
		
		while(shallcontinue) {
			System.out.println("What would you like to do?");
			System.out.println("\n 1. Add User \n 2. Update User \n 3. Search User \n 4. Delete User \n 5. Print User Details\n 6. Exit  ");
		
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
			
			case 1: 
			System.out.println("***Add User***");
				
			System.out.println("****Add user details******");

			System.out.println(" Enter first Name :");
			user.FirstName = sc.next();

			System.out.println(" Enter Last Name :");
			user.LastName = sc.next();

			System.out.println(" Enter gender :");
			user.gender = sc.next();

			System.out.println(" Enter age :");
			user.age = sc.nextInt();

			System.out.println("   Enter email");
			user.email = sc.next();

			System.out.println("Enter password");
			user.password = sc.next();

			System.out.println("Enter  confirm password");
			user.ConfirmPassword = sc.next();

			if (user.password.equals(user.ConfirmPassword)) {
				user.password = user.password;
			} else {
				System.out.println("Enter confirm password");

			}
			 System.out.println("Product Added Successfully!!");
			 
			 UserListFromFile.add(user.FirstName+"," + user.LastName+","+user.gender+","+user.age+","+user.email);
			 
					break;
					
			case 2:
				System.out.println("****Update User****");
				
				Scanner sc1=new Scanner(System.in);
				
				System.out.println("\nEnter the user name to update: ");
				String UserNameToUpdate=sc.next();
				
				for(int i=0;i<UserListFromFile.size();i++) {
					if(UserListFromFile.get(i).contains(UserNameToUpdate)) {
				System.out.println(" Enter first Name :");
				String UpdatedFirstName = sc1.next();

				System.out.println(" Enter Last Name :");
				String UpdatedLastName = sc1.next();

				System.out.println(" Enter gender :");
				String Updatedgender = sc1.next();

				System.out.println(" Enter age :");
				int Updatedage = sc1.nextInt();

				System.out.println("   Enter email");
				String email = sc1.next();
				
				UserListFromFile.set(i, UpdatedFirstName+","+UpdatedLastName+","+Updatedage+","+Updatedgender);
				
				}
			}
					break;
			
			case 3: System.out.println("***Search Product****");
			        System.out.println("Enter the user name to search:  ");
			        
			        Scanner scToSearch=new Scanner(System.in);
			        String UserNametoSearch=scToSearch.next();
			        
			        for(int i=0;i<UserListFromFile.size();i++) {
			        	if(UserListFromFile.get(i).contains(UserNametoSearch)) {
			        		System.out.println("User Found !!");
			        		System.out.println(UserListFromFile.get(i));
			        	}
			        }
			
					break;
					
			case 4:
				System.out.println("***Delete User***");
				System.out.println("Enter the user name to delete: ");
				Scanner scToDelete=new Scanner(System.in);
				
				String UserNameToDelete=scToDelete.next();
				
				for(int i=0;i<UserListFromFile.size();i++) {
					if(UserListFromFile.get(i).contains(UserNameToDelete)) {
						UserListFromFile.remove(i);
					}
				}
					break;
			
			case 5:
				System.out.println("***Print User Details***");
				for(String tempUser: UserListFromFile) {
					System.out.println(tempUser);
				}
					break;
					
			case 6:
				System.out.println("Existing the application...");
				shallcontinue = false;
				break;
				
			default:
				System.out.println("Unknown option");

				
			}
		}
	}
	public void LoadUserDataFromFile() throws IOException {
		
		String filepathToRead="C:\\Users\\user\\eclipse-workspace\\EcommerceUsingArray\\src\\UserManagement\\User";
		File file=new File(filepathToRead);
		FileReader fileReader=new FileReader(file);
		
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
		String line="";
		while((line=bufferedReader.readLine())!=null) {
			UserListFromFile.add(line);
		}
		bufferedReader.close();
	}
	public void writeProductDataIntoFile() throws IOException {
		String filepathToWrite="C:\\Users\\user\\eclipse-workspace\\EcommerceUsingArray\\src\\UserManagement\\User";
		
		File file=new File(filepathToWrite);
		
		FileWriter fileWriter=new FileWriter(file, false);
		BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
		
		for(String product: UserListFromFile) {
			bufferedWriter.write(product);
		}
		bufferedWriter.close();
		
	}
	
}
