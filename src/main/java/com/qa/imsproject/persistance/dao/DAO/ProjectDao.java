package com.qa.imsproject.persistance.dao.DAO;
/**
 * Dao interface to be implemented by the other DAOs
 */
import java.util.ArrayList;

public interface ProjectDao <T> {

	//Create 
	public void create(T t);
		
	//Read
	public ArrayList<T> readAll();
	
	//Update
	public void update(T t);
	
	//Delete
	public void delete(int id);
}

