package com.qa.imsproject.persistance.dao.classes;

public class ProjectOrder {
	
	private Long id;
	private Long customerId;
	private int quantity;
	private Long purchaseId;
	private String item;
	private Double price;
	
	public ProjectOrder(long id, long customerId) {
		
		this.setId(id);
		this.setCustomerId(customerId);
	}


	public ProjectOrder(Long purchaseId, String item, int quantity, Double price) {
		// TODO Auto-generated constructor stub
	this.setPurchaseId(purchaseId);
	this.setItem(item);
	this.setQuantity(quantity);
	this.setPrice(price);
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Long getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}

	
	
}
