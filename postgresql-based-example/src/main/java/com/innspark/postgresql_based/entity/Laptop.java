package com.innspark.postgresql_based.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer laptopId;
	private String laptopName;
	private String color;
	private Double price;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(Integer laptopId, String laptopName, String color, Double price) {
		super();
		this.laptopId = laptopId;
		this.laptopName = laptopName;
		this.color = color;
		this.price = price;
	}

	public Integer getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", color=" + color + ", price=" + price
				+ "]";
	}

}
