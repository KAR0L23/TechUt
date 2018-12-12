package ug.ktomczyk.techut.zad04.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Phone {
	
	private long id;
	private double price;
	private Date productionDate;
	private boolean isReserved;
	private License license;
	private Producer producer;
	private List<Person> persons;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public Phone(double price, Date productionDate, boolean isReserved, Producer producer, License license, List<Person> persons) {
		super();
		this.price = price;
		this.productionDate = productionDate;
		this.isReserved = isReserved;
		this.producer = producer;
		this.license = license;
		this.persons = persons;
	}
	public Phone() {
		super();
	}
	
	// Phone has unique license, License has unique phone
	@OneToOne
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	
	// Producer has many phones
    @ManyToOne
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
    
    // Phone has many persons
    @OneToMany
    public List<Person> getPersons() {
        return persons;
    }

    public void setPilots(List<Person> persons) {
        this.persons = persons;
    }
}

