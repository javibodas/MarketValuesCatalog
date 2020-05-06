package com.jgonzalbo.bolsavalores.models;

public class Index {
	
	private int id;
	private String name;
	private String country;
	private String price;
	private String day_performance;
	
	public Index() {}

	public Index(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDay_performance() {
		return day_performance;
	}

	public void setDay_performance(String day_performance) {
		this.day_performance = day_performance;
	}
	
	@Override
	public String toString() {
		return "Index [id=" + id + ", name=" + name + ", country=" + country + ", price=" + price + ", day_performance="
				+ day_performance + "]";
	}

}
