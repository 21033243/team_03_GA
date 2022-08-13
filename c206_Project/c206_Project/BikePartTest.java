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

package c206_Project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BikePartTest {

	private BikeParts BP1;
	private BikeParts BP2;
	
	private ArrayList <BikeParts> BikePartsList;
	
	@BeforeEach
	void setUp() throws Exception {
		
		BP1 = new BikeParts(001,"Bike Seat",10);
		BP2 = new BikeParts(002,"Bike Helmet",10);
		
		BikePartsList = new ArrayList<BikeParts>();
	}
	
	
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testAddBikeParts() {
	
	// Test if the Bike Part List is not null, so we are able to add a new bike part - boundary test
	assertNotNull("Test if there is a valid Bike Parts arraylist to add to", BikePartsList);
	
	// Given that the list is empty, after adding 1 bike part, the size of the list becomes 1 - normal test
	// Bike added is the same as the first bike part of the list
	
	customerManagement.addBikeParts(BikePartsList, BP1);
	assertEquals("Test if the bike arraylist size is 1", 1, BikePartsList.size());
	assertSame("Check that Bike is added", BP1, BikePartsList.get(0));
	
	// add another bike part, test if the size of the BikePartList is 2 - normal test
	// Bike added is same as second bike of the list
	
	customerManagement.addBikeParts(BikePartsList, BP2);
	assertEquals("Check that the bike arraylist size is 2", 2, BikePartsList.size());
	assertSame("Check that bike is added", BP2, BikePartsList.get(1));
	
	}
	@Test
	public void testRetrieveBikeParts() {
		
		// test that the bike part list is not null but empty - boundary testing
		assertNotNull("Test if there are valid bikes in the arraylist to retrieve bikes", BikePartsList);	
		
		// test if the list of bike parts retrieved is empty - boundary testing
		String allBikeParts = customerManagement.RetreiveBikeParts(BikePartsList);
		String testOutput = "";
		assertEquals("Check that getBikePartsList is the same", testOutput, allBikeParts);
		
		// Given an empty bike part list, after adding 2 bike Parts, test that the size of the bike part list is 2 - normal test
		customerManagement.addBikeParts(BikePartsList, BP1);
		customerManagement.addBikeParts(BikePartsList, BP2);
		assertEquals("Test that the BikeParts arraylist size is 2", 2, BikePartsList.size());
		
		// test if the expected output string is the same as the list of bike Parts retrieved
		allBikeParts = customerManagement.RetreiveBikeParts(BikePartsList);
		testOutput += String.format("%-10d %-20s %-20d\n",001,"Bike Seat",10);
		testOutput += String.format("%-10d %-20s %-20d\n",002,"Bike Helmet",10);
		
		assertEquals("Test that the bikePartList is valid", testOutput, allBikeParts);
	}
	
	@Test 
	public void testDeleteBikeParts() {
		assertNotNull("test that there is a valid bike arraylist to delete", BikePartsList);
		
		customerManagement.addBikeParts(BikePartsList, BP1);
		
		Boolean checkBikePart = customerManagement.DeleteBikeParts(BikePartsList, 001 );
		assertTrue("Test if a bike in bikeList can be successfully removed", checkBikePart);
		
		checkBikePart = customerManagement.DeleteBikeParts(BikePartsList, 002 );
		assertFalse("Test that a bike that is not in the arraylist cannot be deleted", checkBikePart);
	}
	
	@Test 
	public void testUpdateBikeParts() {
		
		assertNotNull("test if there is a valid bike arraylist to update", BikePartsList);
		
		customerManagement.addBikeParts(BikePartsList, BP1);
		
		Boolean checkBikePart = customerManagement.UpdateBikeParts(BikePartsList,001,"Bike Seat",10);
		assertTrue("Test if bike details in bikelist is correctly stored", checkBikePart);
		
		checkBikePart = customerManagement.UpdateBikeParts(BikePartsList,002,"Bike Helmet",10);
		assertFalse("Test that a bike that does not exist cannot be updated", checkBikePart);
	}
}
