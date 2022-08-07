/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21033243, 7 Aug 2022 4:42:44 pm
 */

package c206_Project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
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
class customerManagementTest {
	private customer c1;
	private customer c2;
	
	private ArrayList<customer> customerList;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// prepare test data
		c1 = new customer(1001, 90024496, "Jack", "jack@gmail.com");
		c2 = new customer(1002, 90079114, "Mary", "mary@gmail.com");
		
		customerList= new ArrayList<customer>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testAddCamcorder() {
		// Test if Customer list is not null, so that can add a new customer - boundary
		assertNotNull("Test if there is valid Customer arraylist to add to", customerList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		customerManagement.addCustomer(customerList, c1);		
		assertEquals("Test if that customer arraylist size is 1?", 1, customerList.size());
		assertSame("Check that customer is added", c1, customerList.get(0));

		//Add another customer. test The size of the list is 2? -normal
		//The customer just added is as same as the first item of the list
		customerManagement.addCustomer(customerList, c2);
		assertEquals("Check that customer arraylist size is 2", 2, customerList.size());
		assertSame("Check that customer is added", c2, customerList.get(1));
	}
	
	@Test
	public void testRetrieveAllCustomers() {
		// Test if customer list is not null but empty -boundary
		assertNotNull("Test if there is valid customers arraylist to retrieve item", customerList);
		
		//test if the list of customers retrieved is empty - boundary
		String allCustomers= customerManagement.retrieveAllCustomers(customerList);
		String testOutput = "";
		assertEquals("Check that getCustomerDetail is the same", testOutput, allCustomers);
		
		//Given an empty customer list, after adding 2 customers, test if the size of the list is 2 - normal
		customerManagement.addCustomer(customerList, c1);
		customerManagement.addCustomer(customerList, c2);
		assertEquals("Test that customer arraylist size is 2", 2, customerList.size());
		
		//test if the expected output string same as the list of customers retrieved	
		allCustomers= customerManagement.retrieveAllCustomers(customerList);
		testOutput += String.format("%-10d %-20d %-20s %-20s\n", 1001, 90024496, "Jack", "jack@gmail.com" );
		testOutput += String.format("%-10d %-20d %-20s %-20s\n", 1002, 90079114, "Mary", "mary@gmail.com" );
	
		assertEquals("Test that customerList is valid", testOutput, allCustomers);
		 
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
	
	@Test
	public void testdoDelete() {
		
		//boundary
		assertNotNull("test if there is valid customer arraylist to delete", customerList);
		
		customerManagement.addCustomer(customerList, c1);
		
		// normal
		Boolean checkCustomer = customerManagement.doDeleteCustomer(customerList, 1001 );
		assertTrue("Test if an customer is in customer list and can be successfully deleted", checkCustomer);

		//error condition
		checkCustomer = customerManagement.doDeleteCustomer(customerList, 1500 );
		assertFalse("Test that non-existing  customer is cannot be deleted?", checkCustomer);
		
	}

}
