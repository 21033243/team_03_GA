

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 2100 8857, 13 Aug 2022 14:10:20 pm
 */

/**
 * @author ELIJAH GOH
 *
 */

package c206_Project;

public class BikeParts {
	
	//Section I // Fields
	
	private int id;
	private int quantity;
	private String partName;
	
	
	public BikeParts(int id, String partName, int quantity) {
	
		this.id = id;
		this.partName = partName;
		this.quantity = quantity;
		
	}
	
	//Section II // Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	
	
	
	
	
	

}
