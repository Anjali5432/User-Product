package com.user.uapp.model;

public class APIResponse {
	private User user;
	private Product product;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APIResponse(User user, Product product) {
		super();
		this.user = user;
		this.product = product;
	}
	
	
}
