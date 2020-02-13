package com.qa.imsproject.services;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.imsproject.persistance.dao.DAO.ProjectOrderDao;
import com.qa.imsproject.persistance.dao.classes.ProjectOrder;
import com.qa.imsproject.utilities.ProjectUtils;

public class PurchaseSubMenu implements ServicesInterface {

	public static final Logger LOGGER = Logger.getLogger(PurchaseSubMenu.class);

	@Override
	public void serviceInterfaceMenu() throws SQLException {


		LOGGER.info("Initiating Purchase menu...");

		boolean cont = true;

		while (cont) {

			LOGGER.info("This is the Purchase menu, please refer to which command you wish to use. \r\n"
					+ "NOTE: YOU MUST CREATE A PURCHASE ID BEFORE CREATING AN ORDER! \r\n" + "Type either: \r\n"
					+ "CREATE ID \r\n" + "CREATE ORDER \r\n" + "READ ID \r\n" + "READ ORDER \r\n" + "UPDATE \r\n"
					+ "DELETE \r\n" + "EXIT");

			String action = ProjectUtils.scanner1.nextLine().toUpperCase();

			switch (action) {
			case "CREATE ID":
				ProjectOrderDao dao = new ProjectOrderDao();
				dao.createPurchaseId(null);
				break;

			case "CREATE ORDER":
				ProjectOrderDao dao2 = new ProjectOrderDao();
				dao2.create(null);
				break;

			case "READ ID":
				ProjectOrderDao dao3 = new ProjectOrderDao();
				ArrayList<ProjectOrder> purchaseId = dao3.readPurchaseId();
				for (ProjectOrder PurchaseId : purchaseId) {
					System.out.println(
							"PurchaseID: " + (PurchaseId.getId() + "| CustomerID: " + PurchaseId.getCustomerId()));
				}
				break;

			case "READ ORDER":
				ProjectOrderDao dao4 = new ProjectOrderDao();
				ArrayList<ProjectOrder> purchases = dao4.readAll();
				for (ProjectOrder Purchase : purchases) {
					System.out.println("Purchase ID: " + Purchase.getPurchaseId() + "| Item: " + Purchase.getItem()
							+ "| Quantity: " + Purchase.getQuantity() + "| Price: " + Purchase.getPrice());
				}
				break;

			case "UPDATE":
				ProjectOrderDao dao5 = new ProjectOrderDao();
				dao5.update(null);
				break;

			case "DELETE":
				ProjectOrderDao dao6 = new ProjectOrderDao();
				dao6.delete(0);
				break;

			case "EXIT":
				LOGGER.info("Exiting Purchase menu...");
				cont = false;
				break;

			}
		}
	}
}

	