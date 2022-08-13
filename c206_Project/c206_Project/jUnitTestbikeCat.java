package c206_Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
 * @author Dany 21035198
 *
 */
public class jUnitTestbikeCat {

	private bikeCategory b1;
	private bikeCategory b2;

	private ArrayList<bikeCategory> bikeList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// prepare the test data
		b1 = new bikeCategory(1001, "XSR155", "Yamaha", "155cc");
		b2 = new bikeCategory(1002, "CBR150", "Honda", "149cc");

		bikeList = new ArrayList<bikeCategory>();

	}
	/**
	 * @throws java.langException
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testAddBike() {
		
		// Test if the Bike List is not null, so we are able to add a new bike - boundary test
		assertNotNull("Test if there is a valid Bike arraylist to add to", bikeList);
		
		// Given that the list is empty, after adding 1 bike, the size of the list becomes 1 - normal test
		// Bike added is the same as the first bike of the list
		customerManagement.addBike(bikeList, b1);
		assertEquals("Test if the bike arraylist size is 1", 1, bikeList.size());
		assertSame("Check that Bike is added", b1, bikeList.get(0));
		
		// add another bike, test if the size of the bikeList is 2 - normal test
		// Bike added is same as second bike of the list
		customerManagement.addBike(bikeList, b2);
		assertEquals("Check that the bike arraylist size is 2", 2, bikeList.size());
		assertSame("Check that bike is added", b2, bikeList.get(1));
	}
	
	@Test
	public void testRetrieveAllBike() {
		// test that the bike list is not null but empty - boundary testing
		assertNotNull("Test if there are valid bikes in the arraylist to retrieve bikes", bikeList);
		
		// test if the list of bikes retrieved is empty - boundary testing
		String allBikes = customerManagement.retrieveAllBikes(bikeList);
		String testOutput = "";
		assertEquals("Check that getBikeList is the same", testOutput, allBikes);
		
		// Given an empty bike list, after adding 2 bikes, test that the size of the bike list is 2 - normal test
		customerManagement.addBike(bikeList, b1);
		customerManagement.addBike(bikeList, b2);
		assertEquals("Test that the bike arraylist size is 2", 2, bikeList.size());
		
		// test if the expected output string is the same as the list of bikes retrieved
		allBikes = customerManagement.retrieveAllBikes(bikeList);
		testOutput += String.format("%-10d %-20s %-20s %-20s\n", 1001, "XSR155", "Yamaha", "155cc");
		testOutput += String.format("%-10d %-20s %-20s %-20s\n", 1002, "CBR150", "Honda", "149cc");
		
		assertEquals("Test that the bikeList is valid", testOutput, allBikes);
	}
	
	@Test
	public void testdoDeleteBike() {
		
		assertNotNull("test that there is a valid bike arraylist to delete", bikeList);
		
		customerManagement.addBike(bikeList, b1);
		
		
		Boolean checkBike = customerManagement.doDeleteBike(bikeList, 1001);
		assertTrue("Test if a bike in bikeList can be successfully removed", checkBike);
		
		checkBike = customerManagement.doDeleteBike(bikeList, 1009);
		assertFalse("Test that a bike that is not in the arraylist cannot be deleted", checkBike);
		
	}
	
	@Test
	public void testdoUpdateBike() {
		
		assertNotNull("test if there is a valid bike arraylist to update", bikeList);
		
		customerManagement.addBike(bikeList, b1);
		
		Boolean checkBike = customerManagement.doUpdateBike(bikeList, 1001, "XSR155", "Yamaha", "155cc");
		assertTrue("Test if bike details in bikelist is correctly stored", checkBike);
		
		checkBike = customerManagement.doUpdateBike(bikeList, 1500, "XSR150",  "yamabro", "160cc");
		assertFalse("Test that a bike that does not exist cannot be updated", checkBike);
	}
	
}
