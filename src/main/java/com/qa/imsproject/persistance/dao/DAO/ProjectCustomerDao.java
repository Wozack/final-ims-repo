package com.qa.imsproject.persistance.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.qa.imsproject.persistance.dao.classes.ProjectCustomer;
import com.qa.imsproject.utilities.ProjectUtils;

public class ProjectCustomerDao implements ProjectDao<ProjectCustomer> {

	public static final Logger LOGGER = Logger.getLogger(ProjectCustomerDao.class);

	private Connection connection;

	public ProjectCustomerDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.246.84.97:3306/projectdatabase", "root",
				"nczoedpcw8pGm76J");
	}

	public void create(ProjectCustomer customer) {
		try {
			LOGGER.info("Creating new customer, please enter your customer name: ");
			String name = ProjectUtils.scanner1.nextLine();
			java.sql.Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO customer(customer_name) VALUES ('" + name + "');");
			LOGGER.info("Customer created...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public ArrayList<ProjectCustomer> readAll() {
		// TODO Auto-generated method stub
		ArrayList<ProjectCustomer> customers = new ArrayList<>();
		try {
			LOGGER.info("Returning array of all customers: ");
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("customer_name");
				customers.add(new ProjectCustomer(id, name));
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return customers;
	}

	public void update(ProjectCustomer t) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("Updating customer name, please enter the customer's ID who's name is to be updated: ");
			String oldName = ProjectUtils.scanner2.nextLine();
			LOGGER.info("What do you wish " + oldName + " to be known as: ");
			String newName = ProjectUtils.scanner1.nextLine();
			java.sql.Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE customer SET customer_name = ('" + newName + "') WHERE id = "
					+ oldName + ";");
			LOGGER.info("Customer updated...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			LOGGER.info("Deleting customer from database, please enter the customer's ID to be deleted: ");
			int ID = ProjectUtils.scanner1.nextInt();
			java.sql.Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM customer WHERE id = (" + ID + ");");
			LOGGER.info("Customer deleted...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
}
