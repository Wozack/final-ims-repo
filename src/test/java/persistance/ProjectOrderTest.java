//package persistance;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
//import com.qa.imsproject.persistance.dao.classes.ProjectItem;
//import com.qa.imsproject.persistance.dao.classes.ProjectOrder;
//
//public class ProjectOrderTest {
//
//	private ProjectOrder order;
//	private ProjectOrder other;
//
//		@Before
//		public void setUp() {
//			order = new ProjectOrder(1l, 1l);
//			other = new ProjectOrder(1l, 1l);
//		}
//		
//		@Test
//		public void settersTest() {
//			assertNotNull(order.getId());
//			assertNotNull(order.getCustomerId());
//			
//			
//			order.setId(null);
//			assertNull(order.getId());
//			order.setCustomerId(null);
//			assertNull(order.getCustomerId());
////				
//		}
//		
//		@Test
//		public void equalsWithNull() {
//			assertFalse(order.equals(null));
//		}
//		
//		@Test
//		public void equalsWithDifferentObject() {
//			assertFalse(order.equals(new Object()));
//		}
////		
////		@Test
////		public void createItemWithId() {
////			assertEquals(1l, order.getId());
////			assertEquals(1l, order.getCustomerId());
////			
////		}
//		
//		@Test
//		public void checkEquality() {
//			assertTrue(order.equals(order));
//		}
//		
//		@Test
//		public void checkEqualityBetweenDifferentObjects() {
//			assertTrue(order.equals(other));
//		}
//		
//		@Test
//		public void customerNameNullButOtherNameNotNull() {
//			order.setCustomerId(null);
//			assertFalse(order.equals(other));
//		}
//		
//		@Test
//		public void customerNamesNotEqual() {
//			other.setCustomerId(0l);
//			assertFalse(order.equals(other));
//		}
//		
//		@Test
//		public void checkEqualityBetweenDifferentObjectsNullName() {
//			order.setCustomerId(null);
//			other.setCustomerId(null);
//			assertTrue(order.equals(other));
//		}
//		
//		@Test
//		public void nullId() {
//			order.setId(0l);
//			assertFalse(order.equals(other));
//		}
//		
//		@Test
//		public void nullIdOnBoth() {
//			order.setId(null);
//			other.setId(null);
//			assertTrue(order.equals(other));
//		}
//		
//		@Test
//		public void otherIdDifferent() {
//			other.setId(2L);
//			assertFalse(order.equals(other));
//		}
//		
//		
//		
//		@Test
//		public void constructorWithoutId() {
//			ProjectOrder order = new ProjectOrder(0l, 2l);
//			assertNull(order.getId());
//			assertNotNull(order.getCustomerId());
//			
//		}}
//		
//////		@Test
//////		public void hashCodeTest() {
//////			assertEquals(item.hashCode(), other.hashCode());
//////		}
////		@Test
////		public void hashCodeTestWithNull() {
////			ProjectCustomer customer = new ProjectCustomer(null, null);
////			ProjectCustomer other = new ProjectCustomer(null, null);
////			//assertEquals(customer.hashCode(), other.hashCode());
////		}
////		
////	}
