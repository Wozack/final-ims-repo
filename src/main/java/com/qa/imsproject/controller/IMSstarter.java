package com.qa.imsproject.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.imsproject.services.CustomerSubMenu;
import com.qa.imsproject.services.ItemSubMenu;
import com.qa.imsproject.services.PurchaseSubMenu;
import com.qa.imsproject.utilities.Config;
import com.qa.imsproject.utilities.ProjectUtils;

public class IMSstarter {

	public static final Logger LOGGER = Logger.getLogger(IMSstarter.class);

	public void imsSystem() throws SQLException {
		LOGGER.info("What is your username");
		Config.username = ProjectUtils.scanner1.nextLine();
		LOGGER.info("What is your password");
		Config.password = ProjectUtils.scanner2.nextLine();

		LOGGER.info("Welcome " + Config.username + " to Wozack's Starship IMS!");

		boolean cont = true;

		while (cont) {

			LOGGER.info("This is the IMS menu, please refer to which sub-menu you wish to use. Type either: \r\n"
					+ "CUSTOMER \r\n" + "ITEM \r\n" + "PURCHASE \r\n" + "EXIT");

			String action = ProjectUtils.scanner1.nextLine().toUpperCase();

			switch (action) {
			case "CUSTOMER":
				CustomerSubMenu customerSubMenu = new CustomerSubMenu();
				customerSubMenu.serviceInterfaceMenu();
			break; 
			
			case "ITEM":
				ItemSubMenu itemSubMenu = new ItemSubMenu();
				itemSubMenu.serviceInterfaceMenu();
			break;
			
			case "PURCHASE":
				PurchaseSubMenu purchaseSubMenu = new PurchaseSubMenu();
				purchaseSubMenu.serviceInterfaceMenu();
			break;
			
			case "EXIT":
				LOGGER.info("Logging off " + Config.username + "... \r\n" + "Thank you for using Wozack's Starship IMS!");
				cont = false;
			break;

			}

		}

	}

}
			
