package persistance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;

public class ProjectCustomerTest {

	private ProjectCustomer customer;
	private ProjectCustomer other;
	
	@Before
	public void setUp() {
		customer = new ProjectCustomer(1L, "Chris");
		other = new ProjectCustomer(1L, "Chris");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getName());
		
		
		customer.setId(null);
		assertNull(customer.getId());
		customer.setName(null);
		assertNull(customer.getName());
			
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("Chris", customer.getName());
		
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setName("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setName("chirs");
		other.setName("chris");
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setId(0l);
		other.setId(0l);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}
	
	
	
	@Test
	public void constructorWithoutId() {
		ProjectCustomer customer = new ProjectCustomer("Chris");
		assertNull(customer.getId());
		assertNotNull(customer.getName());
		
	}
	
//	@Test
//	public void hashCodeTest() {
//		assertEquals(customer.hashCode(), other.hashCode());
//	}
//	@Test
//	public void hashCodeTestWithNull() {
//		ProjectCustomer customer = new ProjectCustomer(null, null);
//		ProjectCustomer other = new ProjectCustomer(null, null);
//		assertEquals(customer.hashCode(), other.hashCode());
//	}
//	
}
