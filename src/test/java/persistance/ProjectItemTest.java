package persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.imsproject.persistance.dao.classes.ProjectItem;

public class ProjectItemTest {

	private ProjectItem item;
	private ProjectItem other;
	
	@Before
	public void setUp() {
		item = new ProjectItem(1L, "Chris", 5);
		other = new ProjectItem(1L, "Chris", 5);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getName());
		
		
		item.setId(0);
		assertNull(item.getId());
		item.setName(null);
		assertNull(item.getName());
//			
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId());
		assertEquals("Chris", item.getName());
		assertEquals(5, item.getPrice());
		
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setName("rhys");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName(null);
		other.setName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(0);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(0L);
		other.setId(0L);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	
	
	@Test
	public void constructorWithoutId() {
		ProjectItem item = new ProjectItem(0, "Chris", 0);
		assertNull(item.getId());
		assertNotNull(item.getName());
		
	}
	
////	@Test
////	public void hashCodeTest() {
////		assertEquals(item.hashCode(), other.hashCode());
////	}
//	@Test
//	public void hashCodeTestWithNull() {
//		ProjectItem item = new ProjectItem(0, null, 0);
//		ProjectItem other = new ProjectItem(0, null, 0);
//		//assertEquals(customer.hashCode(), other.hashCode());
//	}
	
}

