/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Dany, 11 Aug 2022 5:50:33 pm
 */

package c206ga;

/**
 * @author Dany 21035198
 *
 */
public class bikeCategory {
	//Fields
	private int bikeid;
	private String bikeName;
	private String bikeBrand;
	private String bikePower;
	
	public bikeCategory(int bikeid, String bikeName, String bikeBrand, String bikePower) {
		this.bikeid = bikeid;
		this.bikeName = bikeName;
		this.bikeBrand = bikeBrand;
		this.bikePower = bikePower;
		
	}

	public int getBikeid() {
		return bikeid;
	}

	public void setBikeid(int bikeid) {
		this.bikeid = bikeid;
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getBikeBrand() {
		return bikeBrand;
	}

	public void setBikeBrand(String bikeBrand) {
		this.bikeBrand = bikeBrand;
	}

	public String getBikePower() {
		return bikePower;
	}

	public void setBikePower(String bikePower) {
		this.bikePower = bikePower;
	}
	
	
	
	

}
