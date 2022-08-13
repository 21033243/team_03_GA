/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 2100 8857, 13 Aug 2022 14:14:30 pm
 */

/**
 * @author ELIJAH GOH
 *
 */

package c206_GA_Bikes;
import java.util.ArrayList;

public class BikePartsMenu {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Bike Parts Details
		
		ArrayList<BikeParts> BikePartsList = new ArrayList<BikeParts>();
		
		BikePartsList.add(new BikeParts(001,"Bike Seat",10));
		BikePartsList.add(new BikeParts(002,"Bike Helmet",10));
		BikePartsList.add(new BikeParts(003,"Bike Lights",10));
		BikePartsList.add(new BikeParts(004,"Bike Engine(Sports)",10));
		BikePartsList.add(new BikeParts(005,"Bike Engine(Economical)",10));
		BikePartsList.add(new BikeParts(006,"Bike Wheel(Tyre and Rims bundle)",10));
		
		int option = 0;
		
		while (option != 5) {
			
			BikePartsMenu.menu();
			option = Helper.readInt("Enter option > ");
			
			if (option == 1) {
				BikePartsMenu.getBikePartDetails(BikePartsList);
				
			} else if (option == 2) {
				System.out.println("ADD");
				
				BikeParts bp = inputBikePart();
				BikePartsMenu.addBikeParts(BikePartsList, bp);
				System.out.println("Bike Parts added");
				
			} else if (option == 3) {
				
				int id = Helper.readInt("Enter id: ");
				String partName = Helper.readString("Replace Part Name > ");
				int quantity = Helper.readInt("Enter new quantity > ");
				
				boolean isUpdated = BikePartsMenu.UpdateBikeParts(BikePartsList, id, partName, quantity);
				
				if (isUpdated) {
					System.out.println("Bike Part Updated");
				} else {
					System.out.println("Failed to update.");
				}
				
			}else if (option == 4) {
				
				int id = Helper.readInt("Enter customer ID > ");
				boolean isDeleted = BikePartsMenu.DeleteBikeParts( BikePartsList, id);
				
				if (isDeleted) {
					System.out.println("Bike Part deleted successfully.");
				} else {
					System.out.println("Failed to delete Bike Part.");
				}
				
			} else if (option == 5){
				System.out.println("Exiting Program");
				
			}else {
				System.out.println("Invalid menu option.");
				
			}
			
				
			
			
			
			
		}
	}	
		
	private static void menu() {
		
		Helper.line(40, "-");
		System.out.println("BIKE LOVERS BIKE PARTS MANAGEMENT");
		Helper.line(40, "-");

		System.out.println("1 > View Bike Parts");
		System.out.println("2 > Add new Bike Parts");
		System.out.println("3 > Update Bike Parts");
		System.out.println("4 > Delete Bike Parts");
		System.out.println("5 > Quit");
	
		}
		
		public static String RetreiveBikeParts(ArrayList<BikeParts> BikePartsList) {
			String output = "";
					
			for (int i = 0; i < BikePartsList.size(); i++) {
				output += String.format("%-10d %-20s %-20d\n", 
						BikePartsList.get(i).getId(),
						BikePartsList.get(i).getPartName(),
						BikePartsList.get(i).getQuantity());
				
			}
			return output;
		}
		
		public static void getBikePartDetails(ArrayList<BikeParts> BikePartsList) {
		
			String output = String.format("%-10d %-20s %-20d\n","id","part name",
			"quantity");
		
				output += RetreiveBikeParts(BikePartsList);
			System.out.println(output);
		
		}

		public static BikeParts inputBikePart() {
			
			int id = Helper.readInt("Enter id > ");
			String partName = Helper.readString("Enter Part Name > ");
			int quantity = Helper.readInt("Enter Quantity > ");
			
			BikeParts bp = new BikeParts (id, partName, quantity);
			return bp;
			
		}
		
		public static void addBikeParts(ArrayList<BikeParts> BikePartsList, BikeParts bp) {
			
			BikePartsList.add(bp);
		}
		
		public static boolean UpdateBikeParts(ArrayList<BikeParts> BikePartsList, int id, String partName,int quantity) {
			boolean isUpdated = false;
			for (int i = 0; i <BikePartsList.size(); i++) {
				if (BikePartsList.get(i).getId() == id) {
					BikePartsList.get(i).setPartName(partName);
					BikePartsList.get(i).setQuantity(quantity);
					isUpdated = true;
				}
			}
			return isUpdated;
		}
		public static boolean DeleteBikeParts(ArrayList<BikeParts> BikePartsList, int id) {
			for (int i = 0; i < BikePartsList.size(); i++) {
				if (BikePartsList.get(i).getId() == id) {
					BikePartsList.remove(i);
					return true;
			}
		
		}
		return false;
		
		
		
		}		
	}




