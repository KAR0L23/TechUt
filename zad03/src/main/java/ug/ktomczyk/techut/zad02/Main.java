package ug.ktomczyk.techut.zad02;

import java.sql.*;
import java.text.ParseException;

import ug.ktocmzyk.techut.zad02.domain.Phone;
import ug.ktomczyk.techut.zad02.service.PhoneService;

public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ParseException {
	
	    	
	
			Phone b1 = new Phone("Iphone", Double.parseDouble("999.99"), new Date(118, 01, 11), false);
	    	Phone b2 = new Phone("Samsung", Double.parseDouble("1499.90"), new Date(115, 12, 15), true);
	    	
	        PhoneService bs = new PhoneService();
	
	        bs.addPhone(b1);
	        bs.addPhone(b2);
	        
	        Phone phone = bs.getPhoneById(4);
	        //System.out.println(phone);
	        //bs.deletePhoneById(5);
	        //bs.deleteAllPhones();
	        //System.out.println(bs.getAllPhones());
	}
	

}

