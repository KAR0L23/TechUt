package ug.ktomczyk.techut.zad02.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktomczyk.techut.zad02.domain.Phone;
import ug.ktomczyk.techut.zad02.domain.User;
import ug.ktomczyk.techut.zad02.domain.License;

@Component
@Transactional
public class PhoneManagerHibernateImpl implements PhoneManager {

	@Autowired
	SessionFactory hsf;
	
	@Override
	public void addPhone(Phone phone) {
		hsf.getCurrentSession().save(phone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Phone> getAllPhones() {
		return hsf.getCurrentSession().getNamedQuery("phones.all").list();
	}

	@Override
	public Phone findById(long id) {
		return (Phone) hsf.getCurrentSession().get(Phone.class, id);
	}

	@Override
	public void updatePhone(Phone phone) {
		hsf.getCurrentSession().update(phone);
	}

	@Override
	public void deletePhone(Phone phone) {
		 hsf.getCurrentSession().delete(phone);
	}

	@Override
	public List<User> getPhoneUsers(Phone phone) {
        phone = (Phone) hsf.getCurrentSession().get(Phone.class, phone.getId());

        List<User> users = new ArrayList<User>(phone.getUsers());

        return users;
	}

	@Override
	public void relatePhoneAndUser(long phoneId, long userId) {
        Phone phone = findById(phoneId);
        User user = (User) hsf.getCurrentSession().get(User.class, userId);

        phone.getUsers().add(user);
		
	}

	@Override
	public void giveLicense(long phoneId, long licenseId) {
		Phone phone = (Phone) hsf.getCurrentSession().get(Phone.class, phoneId);
		License license = (License) hsf.getCurrentSession().get(License.class, licenseId);

        phone.setLicense(license);
		
	}
}

