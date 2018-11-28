package ug.ktomczyk.techut.zad02.domain;

import java.sql.Date;

public class Phone {
	
	private String producer;
	private double price;
	private Date productionDate;
	private boolean isReserved;
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	
	@Override
	public String toString() {
		return "Phone [producer=" + producer + ", price=" + price + ", productionDate=" + productionDate
				+ ", isReserved=" + isReserved + "]";
	}
	
	public Phone(String producer, double price, Date productionDate, boolean isReserved) {
		super();
		this.producer = producer;
		this.price = price;
		this.productionDate = productionDate;
		this.isReserved = isReserved;
	}
	public Phone() {
		super();
	}
	
	
	
	
	
	

	
}

