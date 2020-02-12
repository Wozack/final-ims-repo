package com.qa.imsproject.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.imsproject.persistance.dao.DAO.ProjectCustomerDao;
import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
import com.qa.imsproject.utilities.ProjectUtils;

public class CustomerSubMenu implements ServicesInterface {

	public static final Logger LOGGER = Logger.getLogger(CustomerSubMenu.class);

	@Override
	public void serviceInterfaceMenu() throws SQLException {
		// TODO Auto-generated method stub

		LOGGER.info("Initiating Customer menu...");

		boolean cont = true;

		while (cont) {

			LOGGER.info("This is the Customer menu, please refer to which command you wish to use. Type either: \r\n"
					+ "CREATE \r\n" + "READ \r\n" + "UPDATE \r\n" + "DELETE \r\n" + "EXIT");

			String action = ProjectUtils.scanner1.nextLine().toUpperCase();

			switch (action) {
			case "CREATE":
				ProjectCustomerDao dao = new ProjectCustomerDao();
				dao.create(null);
				break;

			case "READ":
				ProjectCustomerDao dao2 = new ProjectCustomerDao();
				ArrayList<ProjectCustomer> customers = dao2.readAll();
				for (ProjectCustomer customer : customers) {
					System.out.println("Customer ID: " + customer.getId() + "| Customer Name: " + customer.getName());
				}
				break;

			case "UPDATE":
				ProjectCustomerDao dao3 = new ProjectCustomerDao();
				dao3.update(null);
				break;

			case "DELETE":
				ProjectCustomerDao dao4 = new ProjectCustomerDao();
				dao4.delete(0);
				break;

			case "EXIT":
				LOGGER.info("Exiting Customer menu...");
				cont = false;
				break;

			}
		}
	}
}
