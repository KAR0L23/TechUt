package ug.ktomczyk.techut.zad02.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktomczyk.techut.zad02.domain.License;

@Component
@Transactional
public class LicenseManagerHibernateImpl implements LicenseManager {

	@Autowired
	SessionFactory hsf;
	
	
	@Override
	public void addLicense(License license) {
		hsf.getCurrentSession().save(license);
	}

}
