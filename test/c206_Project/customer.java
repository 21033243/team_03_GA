/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21033243, 7 Aug 2022 11:14:33 am
 */

package c206_Project;

/**
 * @author 21033243
 *
 */
public class customer {
	//Fields 
	private int id;
	private int mobileNumber;
	private String name;
	private String email;
	
	public customer(int id, int mobileNumber, String name, String email) {
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
