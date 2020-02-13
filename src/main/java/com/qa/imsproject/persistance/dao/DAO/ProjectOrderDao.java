package com.qa.imsproject.persistance.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.imsproject.persistance.dao.classes.ProjectOrder;
import com.qa.imsproject.utilities.Config;
import com.qa.imsproject.utilities.ProjectUtils;

public class ProjectOrderDao implements ProjectDao<ProjectOrder> {

	public static final Logger LOGGER = Logger.getLogger(ProjectOrderDao.class);

	private Connection connection;

	public ProjectOrderDao() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://35.246.84.97:3306/projectdatabase", Config.getUsername(),
				Config.getPassword());
	}

	public void createPurchaseId(ProjectOrder t) throws SQLException {
		// TODO Auto-generated method stub
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info(
					"Creating new order - this requires you to create a new purchase ID, who is making the order? Please enter customer ID: ");
			String customerId = ProjectUtils.scanner3.nextLine();
			statement.executeUpdate("INSERT INTO purchase(customer_id) VALUES ('" + customerId + "');");
			LOGGER.info("Purchase ID created...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public ArrayList<ProjectOrder> readPurchaseId() {
		// TODO Auto-generated method stub
		ArrayList<ProjectOrder> PurchaseId = new ArrayList<ProjectOrder>();
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("To retrieve your Purchase ID, please enter your Customer ID");
			String custoId = ProjectUtils.scanner1.nextLine();
			ResultSet resultSet = statement
					.executeQuery("select * from purchase where customer_id = '" + custoId + "';");
			while (resultSet.next()) {
				Long purchaseId = resultSet.getLong("id");
				Long customerId = resultSet.getLong("customer_id");
				PurchaseId.add(new ProjectOrder(purchaseId, customerId));
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

		return PurchaseId;
	}

	public void update(ProjectOrder t) {
		// TODO Auto-generated method stub
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("Updating a created order, please enter the purchase ID of the order to be updated: ");
			String purchaseId = ProjectUtils.scanner3.nextLine();
			LOGGER.info("Now enter which aspect of the purchase you wish to change, enter either ITEM or QUANTITY: ");
			String imput = ProjectUtils.scanner2.nextLine();
			String option = imput.toUpperCase();

			if (option.equals("ITEM")) {
				LOGGER.info("Finally enter in the new item ID of the item you wish to purchase: ");
				String itemId = ProjectUtils.scanner1.nextLine();
				statement.executeUpdate(
						"UPDATE items_to_order SET item_id = " + itemId + "  WHERE purchase_id = " + purchaseId + ";");

			} else if (option.equals("QUANTITY")) {
				LOGGER.info("Finally enter in the new quantity of the item you wish to purchase: ");
				String itemCount = ProjectUtils.scanner1.nextLine();
				statement.executeUpdate("UPDATE items_to_order SET item_count = " + itemCount + "  WHERE purchase_id = "
						+ purchaseId + ";");
			}
			LOGGER.info("Order updated...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

	public void delete(int id) {
		// TODO Auto-generated method stub

		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info("Deleting order from database, please enter the purchase ID of the order to be deleted: ");
			int ID = ProjectUtils.scanner1.nextInt();
			statement.executeUpdate("DELETE FROM items_to_order WHERE purchase_id = (" + ID + ");");
			LOGGER.info("Order deleted...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public void create(ProjectOrder t) {
		// TODO Auto-generated method stub
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info(
					"Creating new order, if you do not have a purchase ID for this transaction please create one. Please enter purchase ID: ");
			String purchaseId = ProjectUtils.scanner3.nextLine();
			LOGGER.info("Next please enter the item ID of the item you wish to purchase: ");
			String itemId = ProjectUtils.scanner2.nextLine();
			LOGGER.info("Finally enter in the quantity of the item you wish to purchase: ");
			String itemCount = ProjectUtils.scanner1.nextLine();
			statement.executeUpdate("INSERT INTO items_to_order(item_id, item_count, purchase_id) VALUES ('" + itemId
					+ "', '" + itemCount + "', '" + purchaseId + "');");
			LOGGER.info("Order Created...");
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public ArrayList<ProjectOrder> readAll() {
		ArrayList<ProjectOrder> PurchaseList = new ArrayList<ProjectOrder>();
		try (java.sql.Statement statement = connection.createStatement()) {
			LOGGER.info(
					"Returning array of purchases along with the total cost of the purchase, please find your appropriate purchase ID");
			ResultSet resultSet = statement.executeQuery(
					"select item_id, item_count, purchase_id, item_name, item_price, (item_price * item_count) as order_total from  items_to_order join item on items_to_order.item_id=item.id;");
			while (resultSet.next()) {
				int Quantity = resultSet.getInt("item_count");
				Long PurchaseId = resultSet.getLong("purchase_id");
				String Item = resultSet.getString("item_name");
				Double Price = resultSet.getDouble("order_total");

				PurchaseList.add(new ProjectOrder(PurchaseId, Item, Quantity, Price));
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return PurchaseList;

	}

}
