package persistance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
import com.qa.imsproject.persistance.dao.classes.ProjectItem;
import com.qa.imsproject.persistance.dao.classes.ProjectOrder;

public class ProjectOrder2Test {

	private ProjectOrder order;
	private ProjectOrder other;

		@Before
		public void setUp() {
			order = new ProjectOrder(1l, "item", 1, 5d);
			other = new ProjectOrder(1l,"item", 1, 5d);
		}
		
		@Test
		public void settersTest() {
			assertNotNull(order.getPurchaseId());
			assertNotNull(order.getItem());
			assertNotNull(order.getQuantity());
			assertNotNull(order.getPrice());
			
			order.setPurchaseId(null);
			assertNull(order.getPurchaseId());
			order.setItem(null);
			assertNull(order.getItem());
			order.setQuantity(0);
			assertNull(order.getQuantity());
			order.setPrice(null);
			assertNull(order.getPrice());
		}
		
		@Test
		public void equalsWithNull() {
			assertFalse(order.equals(null));
		}
		
		@Test
		public void equalsWithDifferentObject() {
			assertFalse(order.equals(new Object()));
		}
		
//		@Test
//			public void createItemWithId() {
//			assertEquals(1L, order.getPurchaseId());
//			assertEquals("Item", order.getItem());
//			assertEquals(1, order.getQuantity());
//			assertEquals(5d, order.getPrice());		
//	}
		
		@Test
		public void checkEquality() {
			assertTrue(order.equals(order));
		}
		
		@Test
		public void checkEqualityBetweenDifferentObjects() {
			assertTrue(order.equals(other));
		}
		
		@Test
		public void customerNameNullButOtherNameNotNull() {
			order.setPrice(null);
			assertFalse(order.equals(other));
		}
		
		@Test
		public void customerNamesNotEqual() {
			other.setPrice(0d);
			assertFalse(order.equals(other));
		}
		
		@Test
		public void checkEqualityBetweenDifferentObjectsNullName() {
			order.setPrice(null);
			other.setPrice(null);
			assertTrue(order.equals(other));
		}
		
		@Test
		public void nullId() {
			order.setId(0l);
			assertFalse(order.equals(other));
		}
		
		@Test
		public void nullIdOnBoth() {
			order.setId(0L);
			other.setId(0L);
			assertTrue(order.equals(other));
		}
		
		@Test
		public void otherIdDifferent() {
			other.setId(2L);
			assertFalse(order.equals(other));
		}
		
		
		
		@Test
		public void constructorWithoutId() {
			ProjectCustomer customer = new ProjectCustomer("Chris");
			assertNull(customer.getId());
			assertNotNull(customer.getName());
			
		}

}
