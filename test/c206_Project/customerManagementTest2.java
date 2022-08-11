/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21033243, 11 Aug 2022 11:51:29 pm
 */

package c206_Project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 21033243
 *
 */
class customerManagementTest2 {

	private customer c1;
	private customer c2;
	
	private ArrayList<customer> customerList;


	@BeforeEach
	void setUp() throws Exception {
		// prepare test data
		c1 = new customer(1001, 90024496, "Jack", "jack@gmail.com");
		c2 = new customer(1002, 90079114, "Mary", "mary@gmail.com");
		
		customerList= new ArrayList<customer>();
	}
	


	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testDoUpdateCustomer() {
		
		//boundary
		assertNotNull("test if there is valid customer arraylist to update", customerList);
		
		customerManagement.addCustomer(customerList, c1);
		
		// normal
		Boolean checkCustomer = customerManagement.doUpdateCustomer(customerList, 1001, 90024496, "jack@gmail.com" );
		assertTrue("Test if an customer personal particulars in customer list is correctly stored", checkCustomer);

		//error condition
		checkCustomer = customerManagement.doUpdateCustomer(customerList, 1500, 12345678, "james@gmail.com" );
		assertFalse("Test that non-existing customer is cannot be updated?", checkCustomer);
		
	}

}
