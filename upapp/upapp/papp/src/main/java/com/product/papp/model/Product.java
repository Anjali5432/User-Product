package com.product.papp.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;


@Entity
@Table(name="Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	
	@Column(name = "creator", nullable = false)
	private String creator;
	
	@Column(name = "price")
	private String price;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long pid, String creator, String price) {
		super();
		this.pid = pid;
		this.creator = creator;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", creator=" + creator + ", price=" + price + "]";
	}		
	
}

