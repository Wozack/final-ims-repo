//package persistance;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.qa.imsproject.persistance.dao.DAO.ProjectCustomerDao;
//import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
//import com.qa.imsproject.utilities.Config;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProjectCustomerDaoTest {
//
//	@Mock
//	public Config config;
//	
//	@Mock
//	public Connection connection;
//	
//	@Mock
//	public DriverManager driverManager;
//
//	@Spy
//	@InjectMocks
//	public ProjectCustomerDao dao;
//
//	
//	@Test
//	public void readAllTest() {
//		
//		Mockito.when(config.getUsername()).thenReturn("root");
//		Mockito.when(config.getPassword()).thenReturn("nczoedpcw8pGm76J");
//		ArrayList<ProjectCustomer> customers = dao.readAll();
//		assertEquals(customers.size() > 0, customers);	
//		}
//
//	@Test
//	public void create() {
//		when(Config.getUsername()).thenReturn("root");
//		when(Config.getPassword()).thenReturn("nczoedpcw8pGm76J");
//	
//	
//	
//	
//	
//	}
//
//
//
//
//
//
//}
