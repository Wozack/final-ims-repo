package com.qa.imsproject;

import java.sql.SQLException;
import com.qa.imsproject.controller.IMSstarter;
/**
 * Runner, calls the IMS controller.
 * @author Admin
 *
 */
public class ProjectRunner {

	public static void main(String[] args) throws SQLException {

		IMSstarter imsstarter1 = new IMSstarter();
		imsstarter1.imsSystem();
	}

}










