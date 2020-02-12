  package com.qa.imsproject.persistance.dao.classes;

public class ProjectItem {
	
	private Long id;
	private String name;
	private Double price;

	public ProjectItem(long id, String name, double price) {
		
		this.id=id;
		this.setName(name);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
