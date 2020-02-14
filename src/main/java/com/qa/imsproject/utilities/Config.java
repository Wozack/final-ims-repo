package com.qa.imsproject.utilities;
/**
 * Getters and setters for the Username and Password.
 * @author Admin
 *
 */
public class Config {

	private static String username;
	private static String password;
	
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Config.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Config.password = password;
	}
	
}
