package ug.ktomczyk.techut.zad02.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "phones.all", query = "Select b from Phone b"),
})
public class Phone {
	
	private long id;
	private double price;
	private Date productionDate;
	private boolean isReserved;
	private License license;
	private Producer producer;
	private List<User> users = new ArrayList<User>();
	
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
	
	public Phone(double price, Date productionDate, boolean isReserved, Producer producer, License license, List<User> users) {
		super();
		this.price = price;
		this.productionDate = productionDate;
		this.isReserved = isReserved;
		this.producer = producer;
		this.license = license;
		this.users = users;
	}
	
	public Phone(double price, Date productionDate, boolean isReserved) {
		super();
		this.price = price;
		this.productionDate = productionDate;
		this.isReserved = isReserved;
	}
	public Phone() {
		super();
	}
	
	@OneToOne
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	
    @ManyToOne
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
    
    @ManyToMany
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

