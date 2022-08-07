/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21033243, 7 Aug 2022 11:10:29 am
 */

package c206_Project;

import java.util.ArrayList;

/**
 * @author 21033243
 *
 */
public class customerManagement {

	public static void main(String[] args) {

		// Customer Details
		ArrayList<customer> customerList = new ArrayList<customer>();
		customerList.add(new customer(1001, 90024496, "Jack", "jack@gmail.com"));
		customerList.add(new customer(1002, 90079114, "Mary", "mary@gmail.com"));
		customerList.add(new customer(1003, 83568793, "Tim", "tim@gmail.com"));
		customerList.add(new customer(1004, 88888888, "Jim", "jim@gmail.com"));
				
		int option = 0;

		while (option != 5) {

			customerManagement.menu();
			option = Helper.readInt("Enter option > ");


			if (option == 1) {

				customerManagement.getCustomerDetail(customerList);

			} else if (option == 2) {
				// Add a new customer
				System.out.println("ADD");			
				
					customer cc = inputCustomer();
					customerManagement.addCustomer(customerList, cc);
					System.out.println("Customer added");

			} else if (option == 3) {

				int id = Helper.readInt("Enter id: ");
				int mobileNumber = Helper.readInt("Enter new mobile Number > ");
				String email = Helper.readString("Enter new Email > ");

				boolean isUpdated = customerManagement.doUpdateCustomer(customerList, id, mobileNumber, email);

				if (isUpdated) {
					System.out.println("Customer Updated");
				} else {
					System.out.println("Failed to update. Check the room type or the percentage entered.");
				}
			} else if (option == 4) {

				int id = Helper.readInt("Enter customer ID > ");
				boolean isCancelled = customerManagement.doDeleteCustomer(customerList, id);
				
				if (isCancelled) {
					System.out.println("Customer deleted successfully.");
				} else {
					System.out.println("Failed to delete.");
				}

			} else if (option == 5){
				System.out.println("Good bye!");

			} else {
				System.out.println("Invalid option!");
			}
			
		}
	}

	private static void menu() {
		Helper.line(50, "=");
		System.out.println("BIKE LOVERS CUSTOMERS APP");
		Helper.line(50, "=");

		System.out.println("1. View All Customers");
		System.out.println("2. Add new Customer");
		System.out.println("3. Update Customer");
		System.out.println("4. Delete Customer");
		System.out.println("5. Quit");
	}

	public static String retrieveAllCustomers(ArrayList<customer> customerList) {
		String output = "";

		for (int i = 0; i < customerList.size(); i++) {

			output += String.format("%-10d %-20d %-20s %-20s\n", 
					customerList.get(i).getId(),
					customerList.get(i).getMobileNumber(), 
					customerList.get(i).getName(),
					customerList.get(i).getEmail());
		}
		return output;
	}
	
	public static void getCustomerDetail(ArrayList<customer> customerList) {

		String output = String.format("%-10s %-20s %-20s %-20s\n", "id", "mobile number",
				"name", "email");
		 output += retrieveAllCustomers(customerList);	
		System.out.println(output);
	}

	public static customer inputCustomer() {
		int id = Helper.readInt("Enter id > ");
		int mobile = Helper.readInt("Enter mobile > ");
		String name = Helper.readString("Enter Name > ");
		String email = Helper.readString("Enter email > ");

		customer cc= new customer (id, mobile, name,email);
		return cc;
		
	}
	public static void addCustomer(ArrayList<customer> customerList, customer cc) {
		
		customerList.add(cc);
		
	}
	
	public static boolean doUpdateCustomer(ArrayList<customer> customerList, int id, int mobileNumber, String email) {

		boolean isUpdated = false;

		for (int i = 0; i < customerList.size(); i++) {

			if (customerList.get(i).getId() == id) {
				customerList.get(i).setMobileNumber(mobileNumber);
				customerList.get(i).setEmail(email);
				isUpdated = true;
			}
		}

		return isUpdated;

	}

	public static boolean doDeleteCustomer(ArrayList<customer> customerList, int id) {

		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getId() == id) {
				customerList.remove(i);
				return true;
			}
		}
		return false;

	}
}
