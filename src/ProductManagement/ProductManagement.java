package ProductManagement;
import java.util.*;
import java.io.*;

public class ProductManagement {
	static List<String> productListFromFile = new ArrayList<>();
	
	public static void productManagement() {
		System.out.println("*****Welcome to Product Management*****");
		Scanner sc=new Scanner(System.in);
		boolean shouldcontinue=true;
		
		Product product=new Product();
		
		while(shouldcontinue) {
			System.out.println("\nWaht would you like to do?\n1. Add Product\n2. Update Product\n3. Search Products\n4. Delete Product\n5. Print Product ");
			
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			switch(choice) {
					
			case 1: System.out.println("***Add Product***");
					System.out.println("\nEnter the product details: ");
					System.out.println("\nEnter the product name: ");
					product.productName=sc.next();
			
					System.out.println("Enter the product quantity: ");
					product.productQuantity=sc.nextInt();
			
					System.out.println("Enter the product price: ");
					product.productPrice=sc.nextInt();
					
					System.out.println("Product Added Sucessfully!!!");
					
					productListFromFile.add(product.productName+","+product.productQuantity+","+product.productPrice);
					
					break;
					
			case 2: System.out.println("***Update Product****");
					System.out.println("\nEnter the product name to update: ");
					
					Scanner sctoupdate=new Scanner(System.in);
					String productNametoUpdate=sctoupdate.next();
					
					for(int i=0;i<productListFromFile.size();i++) {
						if(productListFromFile.get(i).contains(productNametoUpdate)) {
							sctoupdate=new Scanner(System.in);
							
							System.out.println("Enter updated product name: ");
							String updatedName=sctoupdate.next();
							
							System.out.println("Enter the updated product quantity: ");
							int updatedQuantity=sctoupdate.nextInt();

							System.out.println("Enter updated the price: ");
							int updatedPrice=sctoupdate.nextInt();
							
							productListFromFile.set(i, updatedName+","+updatedQuantity+","+updatedPrice);
							
							
						}
					}
					
			
					break;
					
			case 3:
					System.out.println("***Search Product***");
					System.out.println("Enter the product name to search: ");
					
					Scanner scToSearch=new Scanner(System.in);
					String productNametoSearch=scToSearch.next();
					
					for(int i=0;i<productListFromFile.size();i++) {
						if(productListFromFile.get(i).contains(productNametoSearch)) {
							System.out.println("Product Found!!");
							System.out.println(productListFromFile.get(i));
						}
					}
					
					break;
					
			case 4:
					System.out.println("***Delete Product****");
					System.out.println("Enter the product name to delete: ");
					Scanner scToDelete=new Scanner(System.in);
					
					String productNameToDelete=sc.next();
					
					for(int i=0;i<productListFromFile.size();i++) {
						if(productListFromFile.get(i).contains(productNameToDelete)) {
							productListFromFile.remove(i);
						}
					}
					break;
					
			case 5:
					System.out.println("****Print Product Details****");
					for(String tempProduct: productListFromFile) {
						System.out.println(tempProduct);
					}
					break;
					
			default:System.out.println("Unknown Choice");
			
			}
		}
	}
	public void loadProductFromfile() throws IOException {
		String filepathToRead="C:\\Users\\user\\eclipse-workspace\\EcommerceUsingArray\\src\\ProductManagement\\Product";
		
		File file=new File(filepathToRead);
		FileReader fileReader=new FileReader(file);
		
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
		String line="";
		while((line=bufferedReader.readLine())!=null) {
			productListFromFile.add(line);
		}
		bufferedReader.close();
	}
	public void writeProductDataIntoFile() throws IOException {
		String filepathToWrite="C:\\Users\\user\\eclipse-workspace\\EcommerceUsingArray\\src\\ProductManagement\\Product";
		
		File file=new File(filepathToWrite);
		
		FileWriter fileWriter=new FileWriter(file, false);
		BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
		
		for(String product: productListFromFile) {
			bufferedWriter.write(product);
		}
		bufferedWriter.close();
		
	}
}
