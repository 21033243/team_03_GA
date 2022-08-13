/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Dany, 13 Aug 2022 3:17:15 pm
 */

package c206ga;

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
public class bikeCatMenuTest {

	private bikeCategory b1;
	private bikeCategory b2;

	private ArrayList<bikeCategory> bikeList;

	void setUp() throws Exception {
		// prepare the test data
		b1 = new bikeCategory(1001, "XSR155", "Yamaha", "155cc");
		b2 = new bikeCategory(1002, "CBR150", "Honda", "149cc");

		bikeList = new ArrayList<bikeCategory>();

	}

	void tearDown() throws Exception {
	}

	
	public void testAddBike() {
		
		// Test if the Bike List is not null, so we are able to add a new bike - boundary test
		assertNotNull("Test if there is a valid Bike arraylist to add to", bikeList);
		
		// Given that the list is empty, after adding 1 bike, the size of the list becomes 1 - normal test
		// Bike added is the same as the first bike of the list
		bikeCatMenu.addBike(bikeList, b1);
		assertEquals("Test if the bike arraylist size is 1", 1, bikeList.size());
		assertSame("Check that Bike is added", b1, bikeList.get(0));
		
		// add another bike, test if the size of the bikeList is 2 - normal test
		// Bike added is same as second bike of the list
		bikeCatMenu.addBike(bikeList, b2);
		assertEquals("Check that the bike arraylist size is 2", 2, bikeList.size());
		assertSame("Check that bike is added", b2, bikeList.get(1));
	}
	
	
}