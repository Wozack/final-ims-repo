package com.qa.imsproject.persistance.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
import com.qa.imsproject.utilities.Config;
import com.qa.imsproject.utilities.ProjectUtils;

/**
 * This is the ProjectCustomerDao class, this holds the methods that communicate with the remote database.
 * @author Admin
 *
 */
public class ProjectCustomerDao implements ProjectDao<ProjectCustomer> {

	public static final Logger LOGGER = Logger.getLogger(ProjectCustomerDao.class);

	private Connection connection;

	
	/**
	 * Establishes a connection with the database, takes in the username and password to do so.
	 * 
	 */
	
	public ProjectCustomerDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.246.84.97:3306/projectdatabase", Config.getUsername(),
				Config.getPassword());
	}

	/**
	 * Creates a customer in the database.
	 */
	public void create(ProjectCustomer customer) {
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("Creating new customer, please enter your customer name: ");
			String name = ProjectUtils.scanner1.nextLine();
			statement.executeUpdate("INSERT INTO customer(customer_name) VALUES ('" + name + "');");
			LOGGER.info("Customer created...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Lets the user read all customers in the database in an array
	 */
	public ArrayList<ProjectCustomer> readAll() {
		
		ArrayList<ProjectCustomer> customers = new ArrayList<>();
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("Returning array of all customers: ");
			ResultSet resultSet = statement.executeQuery("select * from customer");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("customer_name");
				ProjectCustomer customer = new ProjectCustomer(id, name);
				customers.add(customer);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customers;
	}
/**
 * Lets the user update a customer's name 
 */
	public void update(ProjectCustomer t) {
		
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("Updating customer name, please enter the customer's ID who's name is to be updated: ");
			String oldName = ProjectUtils.scanner2.nextLine();
			LOGGER.info("What do you wish " + oldName + " to be known as: ");
			String newName = ProjectUtils.scanner1.nextLine();
			statement.executeUpdate(
					"UPDATE customer SET customer_name = ('" + newName + "') WHERE id = " + oldName + ";");
			LOGGER.info("Customer updated...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * lets the user delete a customer
	 */
	public void delete(int id) {
		
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("Deleting customer from database, please enter the customer's ID to be deleted: ");
			int ID = ProjectUtils.scanner1.nextInt();
			statement.executeUpdate("DELETE FROM customer WHERE id = (" + ID + ");");
			LOGGER.info("Customer deleted...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
