package ug.ktomczyk.techut.zad02;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import ug.ktomczyk.techut.zad02.domain.Phone;
import ug.ktomczyk.techut.zad02.service.PhoneService;

public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ParseException {
	
	    	
	
			Phone b1 = new Phone("Iphone6s", Double.parseDouble("799.99"), new Date(118, 01, 11), false);
	    	Phone b2 = new Phone("IphoneXs", Double.parseDouble("3499.90"), new Date(115, 12, 15), true);
	    	
	        PhoneService bs = new PhoneService();
	
	        //bs.addPhone(b1);
	        //bs.addPhone(b2);
	        
	        //Phone phone = bs.getPhoneById(2);
	        //System.out.println(phone);
	        //bs.deletePhoneById(5);
	        //bs.deleteAllPhones();
	        //System.out.println(bs.getAllPhones());
	        List<Phone> phones = new ArrayList<Phone>();
	        phones.add(b1);
	        phones.add(b2);
	        bs.addPhones(phones);
	        //System.out.print(bs.getPhonesCheaperThan(1000));
	}
	

}

