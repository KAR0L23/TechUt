package ug.ktomczyk.techut.zad02.service;

import java.util.List;

import ug.ktomczyk.techut.zad02.domain.Phone;
import ug.ktomczyk.techut.zad02.domain.User;

public interface PhoneManager {

	// Telefon
	void addPhone(Phone phone);
	List<Phone> getAllPhones();
	Phone findById(long id);
	void updatePhone(Phone phone);
	void deletePhone(Phone phone);
	
	// Relacje
	List<User> getPhoneUsers(Phone phone);
	void relatePhoneAndUser(long phoneId, long userId);
	void giveLicense(long phoneId, long licenseId);
}

