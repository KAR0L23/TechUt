package ug.ktomczyk.techut.zad02.service;

import java.util.List;

import ug.ktomczyk.techut.zad02.domain.Phone;

public interface PhoneManager {
	public void addPhone(Phone phone);
	public List<Phone> getAllPhones();
	public Phone getPhoneById(int id);
	public List<Phone> getPhonesCheaperThan(double price);
	public void deleteAllPhones();
	public void deletePhoneById(int id);
	public boolean addPhones(List<Phone> phones);
}

