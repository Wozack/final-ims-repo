package com.qa.imsproject.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.imsproject.persistance.dao.DAO.ProjectItemDao;
import com.qa.imsproject.persistance.dao.classes.ProjectItem;
import com.qa.imsproject.utilities.ProjectUtils;

public class ItemSubMenu implements ServicesInterface {

	public static final Logger LOGGER = Logger.getLogger(CustomerSubMenu.class);

	@Override
	public void serviceInterfaceMenu() throws SQLException {
	
		LOGGER.info("Initiating Item menu...");

		boolean cont = true;

		while (cont) {

			LOGGER.info("This is the Item menu, please refer to which command you wish to use. Type either: \r\n"
					+ "CREATE \r\n" + "READ \r\n" + "UPDATE \r\n" + "DELETE \r\n" + "EXIT");

			String action = ProjectUtils.scanner1.nextLine().toUpperCase();

			switch (action) {
			case "CREATE":
				ProjectItemDao dao = new ProjectItemDao();
				dao.create(null);
				break;

			case "READ":
				ProjectItemDao dao2 = new ProjectItemDao();
				ArrayList<ProjectItem> items = dao2.readAll();
				for (ProjectItem item : items) {
					System.out.println("Item ID: " + item.getId() + "| Item: " + item.getName()
							+ "| Item Price-Per-Unit: " + item.getPrice());
				}
				break;

			case "UPDATE":
				ProjectItemDao dao3 = new ProjectItemDao();
				dao3.update(null);
				break;

			case "DELETE":
				ProjectItemDao dao4 = new ProjectItemDao();
				dao4.delete(0);
				break;

			case "EXIT":
				LOGGER.info("Exiting Item menu...");
				cont = false;
				break;

			}
		}
	}
}
