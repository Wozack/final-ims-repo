package com.qa.porjectdaotest;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.qa.imsproject.persistance.dao.DAO.ProjectCustomerDao;
import com.qa.imsproject.persistance.dao.DAO.ProjectItemDao;
import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
import com.qa.imsproject.persistance.dao.classes.ProjectItem;

public class ProjectIMSTest {

	public class ProjectCustomerDaoTest {

		@Test
		public void PCDreadAllTest() throws SQLException {
			ProjectCustomerDao dao = new ProjectCustomerDao();
			ArrayList<ProjectCustomer> customers = dao.readAll();
			for (ProjectCustomer customer : customers) {
				System.out.println("Customer ID: " + customer.getId() + "| Customer Name: " + customer.getName());
			}
		}
	}

//	public void PCDcreateTest() throws SQLException {
//	ProjectCustomerDao dao2 = new ProjectCustomerDao();
//	dao2.create(null);
//	}
//
//	public void PCDdeleteTest() throws SQLException {
//	ProjectCustomerDao dao3 = new ProjectCustomerDao();
//	dao3.delete(0);
//	}
//	
//	public void PCDupdateTest() throws SQLException {
//	ProjectCustomerDao dao4 = new ProjectCustomerDao();
//	dao4.update(null);
//	}

	public class ProjectItemDaoTest {

	@Test
	public void PIDreadAllTest() throws SQLException {
	ProjectItemDao dao6 = new ProjectItemDao();
	ArrayList<ProjectItem> items = dao6.readAll();
	for(ProjectItem item : items)
	{
		System.out.println("Item ID: " + item.getId() + "| Item: " + item.getName() + "| Item Price-Per-Unit: " + item.getPrice());
	}
}
}
}