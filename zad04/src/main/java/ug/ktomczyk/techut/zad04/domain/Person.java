package ug.ktomczyk.techut.zad04.domain;

import javax.persistence.*;

@Entity
public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private int yob;

    public Person(String firstName, String lastName, int yob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yob = yob;
    }

    public Person() {
    	
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }
}

