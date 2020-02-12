package com.qa.imsproject;

import java.sql.SQLException;
import com.qa.imsproject.controller.IMSstarter;

public class ProjectRunner {

	public static void main(String[] args) throws SQLException {

		IMSstarter imsstarter1 = new IMSstarter();
		imsstarter1.imsSystem();
	}

}










