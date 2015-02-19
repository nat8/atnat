package com.epam.natalia_amelina.businessobject;

public class Product {

	private static final String POINT = ".";
	
	private String brand;
	private int price;
	
	public Product(String brand) {
		this.brand = brand;
	}
	
	public Product(String brand, String price) {
		this.brand = brand;
		this.price = convertPriceToInt(price);
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getPrice() {
		return price;
	}
	
	private int convertPriceToInt(String price) {
		int pointIndex = price.indexOf(POINT);
		return Integer.parseInt(price.substring(1, pointIndex));
	}
	
}
