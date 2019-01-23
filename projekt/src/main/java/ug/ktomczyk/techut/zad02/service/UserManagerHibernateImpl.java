package ug.ktomczyk.techut.zad02.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ug.ktomczyk.techut.zad02.domain.User;

@Component
@Transactional
public class UserManagerHibernateImpl implements UserManager {
	
	@Autowired
	private SessionFactory hsf;

	@Override
	public void addUser(User user) {
		hsf.getCurrentSession().save(user);
		
	}
	

}
