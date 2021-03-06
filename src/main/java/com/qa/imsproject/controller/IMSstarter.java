package com.qa.imsproject.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.qa.imsproject.services.CustomerSubMenu;
import com.qa.imsproject.services.ItemSubMenu;
import com.qa.imsproject.services.PurchaseSubMenu;
import com.qa.imsproject.utilities.Config;
import com.qa.imsproject.utilities.ProjectUtils;
/**
 * IMSstarter Class, holds the initial menu.
 * @author Admin
 *
 */
public class IMSstarter {

	public static final Logger LOGGER = Logger.getLogger(IMSstarter.class);

	/**
	 * Method takes in username and password required to access the database. Holds a switch menu that communicates with services.
	 * 
	 */
	public void imsSystem() throws SQLException {
		LOGGER.info("What is your username");
		Config.setUsername(ProjectUtils.scanner1.nextLine());
		LOGGER.info("What is your password");
		Config.setPassword(ProjectUtils.scanner2.nextLine());

		LOGGER.info("Welcome " + Config.getUsername() + " to Wozack's Starship IMS!");

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
				LOGGER.info("Logging off " + Config.getUsername() + "... \r\n" + "Thank you for using Wozack's Starship IMS!");
				cont = false;
			break;

			}

		}

	}

}
			
