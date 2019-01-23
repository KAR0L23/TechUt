package ug.ktomczyk.techut.zad02.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ug.ktomczyk.techut.zad02.domain.Phone;
import ug.ktomczyk.techut.zad02.domain.User;
import ug.ktomczyk.techut.zad02.domain.License;
import ug.ktomczyk.techut.zad02.domain.Producer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class PhoneTest {

    @Autowired
    PhoneManager bm;
    
    @Autowired
    UserManager cm;
    
    @Autowired
    LicenseManager lm;
    
    @Autowired
    ProducerManager pm;
    
    private static final double DELTA = 1e-15;
    
    private static String sDate = "01-01-2015";
	private static Date dDate;
	static {
		try {
			dDate = new SimpleDateFormat("dd-MM-yyyy").parse(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    

    @Test
    public void addPhoneCheck() {
        Phone b = new Phone(999, dDate, true);

        bm.addPhone(b);

        Phone retrieved = bm.findById(b.getId());

        assertEquals(b.getId(), retrieved.getId());
    }

    @Test
    public void getAllPhonesCheck() {
        List<Phone> before = bm.getAllPhones();
    	
        Phone b1 = new Phone(1000, dDate, true);
        Phone b2 = new Phone(2000, dDate, false);

        bm.addPhone(b1);
        bm.addPhone(b2);

        List<Phone> after = bm.getAllPhones();

        assertEquals(before.size() + 2, after.size());
    }

    @Test
    public void findPhoneByIdCheck() {
    	Phone b = new Phone(999, dDate, true);
        bm.addPhone(b);

        long id = b.getId();

        Phone foundPhone = bm.findById(id);

        assertEquals(b.getId(), foundPhone.getId());
    }

    @Test
    public void deletePhoneCheck() {
        List<Phone> before = bm.getAllPhones();

    	Phone b = new Phone(999, dDate, true);
    	
        bm.addPhone(b);
        bm.deletePhone(b);

        List<Phone> after = bm.getAllPhones();

        assertEquals(before.size(), after.size());
    }

    @SuppressWarnings("deprecation")
	@Test
    public void updatePhoneCheck() {
    	Phone b = new Phone(999, dDate, true);
        bm.addPhone(b);

        double newPrice = 100;

        b.setPrice(newPrice);

        bm.updatePhone(b);

        assertEquals(b.getPrice(), newPrice, DELTA);
    }
    
    @Test
    public void phoneAndUserCheck() {
        User c1 = new User("Adam", "Konieczny", 1990);
        User c2 = new User("Krzysztof", "Ibisz", 1980);

        cm.addUser(c1);
        cm.addUser(c2);
        
    	Phone b1 = new Phone(999, dDate, true);
    	Phone b2 = new Phone(555, dDate, false);


        bm.addPhone(b1);
        bm.addPhone(b2);

        List<User> usersOneBefore = bm.getPhoneUsers(b1);
        List<User> usersTwoBefore = bm.getPhoneUsers(b2);
        int beforeOne = usersOneBefore.size();
        int beforeTwo = usersTwoBefore.size();

        bm.relatePhoneAndUser(b1.getId(), c1.getId());
        bm.relatePhoneAndUser(b1.getId(), c2.getId());
        bm.relatePhoneAndUser(b2.getId(), c1.getId());
        bm.relatePhoneAndUser(b2.getId(), c2.getId());
        

        List<User> usersOneAfter = bm.getPhoneUsers(b1);
        List<User> usersTwoAfter = bm.getPhoneUsers(b2);
        int afterOne = usersOneAfter.size();
        int afterTwo = usersTwoAfter.size();

        assertEquals(beforeOne + 2, afterOne);
        assertEquals(beforeTwo + 2, afterTwo);
        assertEquals(b1.getUsers().get(afterOne-2).getFirstName(), c1.getFirstName());
        assertEquals(b1.getUsers().get(afterOne-1).getFirstName(), c2.getFirstName());
        assertEquals(b2.getUsers().get(afterTwo-2).getFirstName(), c1.getFirstName());
        assertEquals(b2.getUsers().get(afterTwo-1).getFirstName(), c2.getFirstName());
    }
    
    @Test
    public void giveLicenseTest() {
 
    	Phone phone = new Phone(999, dDate, true);
        bm.addPhone(phone);

        License license = new License((int) Math.random());
        lm.addLicense(license);

        bm.giveLicense(phone.getId(), license.getId());

        assertEquals(phone.getLicense().getId(), license.getId());
    }
    
    @Test
    public void phoneAndProducersTest() {
 
    	Phone phone = new Phone(999, dDate, true);
        bm.addPhone(phone);

        Producer producer = new Producer("APPLE");
        pm.addProducer(producer);

        pm.assignPhone(phone.getId(), producer.getId());

        assertTrue(producer.getPhones().contains(phone));
    }
}

