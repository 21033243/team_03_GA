/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Dany, 11 Aug 2022 5:57:40 pm
 */

package c206ga;

import java.util.ArrayList;

/**
 * @author Dany 21035198
 *
 */
public class bikeCatMenu {

	public static void main(String[] args) {
		ArrayList<bikeCategory> bikeList = new ArrayList<bikeCategory>();
		bikeList.add(new bikeCategory(1001, "XSR155", "Yamaha", "155cc"));
		bikeList.add(new bikeCategory(1002, "CBR150", "Honda", "149cc"));
		bikeList.add(new bikeCategory(1003, "Bonneville", "Triumph", "865cc"));
		bikeList.add(new bikeCategory(1004, "Forty-Eight", "Harley Davidson", "1200cc"));

		int option = 0;

		while (option != 5) {

			bikeCatMenu.menu();
			option = Helper.readInt("Enter Option > ");

			if (option == 1) {

				bikeCatMenu.getBikeList(bikeList);

			} else if (option == 2) {
				// Add a new Bike
				System.out.println("ADD");

				bikeCategory bc = inputBike();
				bikeCatMenu.addBike(bikeList, bc);
				System.out.println("New Bike Added!");

			} else if (option == 3) {
				// Update Bike
				int id = Helper.readInt("Enter Bike ID > ");
				String bikeName = Helper.readString("Enter New Bike Name > ");
				String bikeBrand = Helper.readString("Enter Bike Brand > ");
				String bikePower = Helper.readString("Enter displacement(cc) of new Bike > ");

				boolean isUpdated = bikeCatMenu.doUpdateBike(bikeList, id, bikeName, bikeBrand, bikePower);

				if (isUpdated) {
					System.out.println("Bike Updated!");

				} else {
					System.out.println("Failed to update. Please check if new Bike follows format.");
				}
			} else if (option == 4) {
				// Delete Bike
				int id = Helper.readInt("Enter Bike ID > ");
				boolean isRemoved = bikeCatMenu.doDeleteBike(bikeList, id);

				if (isRemoved) {
					System.out.println("Bike removed successfully.");
				} else {
					System.out.println("Failed to remove Bike.");
				}

			} else if (option == 5) {
				System.out.println("Thank you for using Bike Lovers Database, Good Bye!");

			} else {
				System.out.println("Invalid Option!");
			}
		}

	}

	private static void menu() {
		Helper.line(50, "=");
		System.out.println("BIKE LOVERS DATABASE");
		Helper.line(50, "=");

		System.out.println("1. View All Bikes");
		System.out.println("2. Add new Bike");
		System.out.println("3. Update Bike");
		System.out.println("4. Delete Bike");
		System.out.println("5. Quit");
	}

	public static String retrieveAllBikes(ArrayList<bikeCategory> bikeList) {
		String output = "";

		for (int i = 0; i < bikeList.size(); i++) {

			output += String.format("%-10d %-20s %-20s %-20s", bikeList.get(i).getBikeid(),
					bikeList.get(i).getBikeName(), bikeList.get(i).getBikeBrand(), bikeList.get(i).getBikePower());
		}
		return output;
	}

	private static void getBikeList(ArrayList<bikeCategory> bikeList) {
		String output = String.format("%-10d %-20s $-20s $-20s", "bike id", "bike name", "bike brand", "bike power");
		output += retrieveAllBikes(bikeList);
		System.out.println(output);
	}

	private static bikeCategory inputBike() {
		int id = Helper.readInt("Enter ID > ");
		String bikename = Helper.readString("Enter Bike Model > ");
		String bikebrand = Helper.readString("Enter Bike Brand > ");
		String bikepower = Helper.readString("Enter Bike Power/Displacement(cc) > ");

		bikeCategory bc = new bikeCategory(id, bikename, bikebrand, bikepower);
		return bc;
	}

	public static void addBike(ArrayList<bikeCategory> bikeList, bikeCategory bc) {
		bikeList.add(bc);
	}

	private static boolean doUpdateBike(ArrayList<bikeCategory> bikeList, int id, String bikeName, String bikeBrand,
			String bikePower) {

		boolean isUpdated = false;

		for (int i = 0; i < bikeList.size(); i++) {

			if (bikeList.get(i).getBikeid() == id) {
				bikeList.get(i).setBikeName(bikeName);
				bikeList.get(i).setBikeBrand(bikeBrand);
				bikeList.get(i).setBikePower(bikePower);
				isUpdated = true;
			}
		}
		return isUpdated;
	}

	private static boolean doDeleteBike(ArrayList<bikeCategory> bikeList, int id) {

		for (int i = 0; i < bikeList.size(); i++) {
			if (bikeList.get(i).getBikeid() == id) {
				bikeList.remove(i);
				return true;
			}
		}
		return false;
	}
}
