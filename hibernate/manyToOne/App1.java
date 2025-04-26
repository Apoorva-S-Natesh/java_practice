package practice.manyToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App1 {
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate1.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		
		Person p1 = new Person();
		Person p2 = new Person();
		
		Bike b1 = new Bike(1001, "Pulasr", p1);
		Bike b2 = new Bike(2002, "Kawasaki", p1);
		Bike b3 = new Bike(3003, "Honda", p2);
		Bike b4 = new Bike(4004, "ROyal Enfield", p2);
		
		List<Bike> bikeList1 = new ArrayList<Bike>();
		bikeList1.add(b1);
		bikeList1.add(b2);
		
		List<Bike> bikeList2 = new ArrayList<Bike>();
		bikeList2.add(b3);
		bikeList2.add(b4);
		
		p1.setId(1);
		p1.setName("Horse");
		p1.setBikeList(bikeList1);
		
		p2.setId(2);
		p2.setName("Duck");
		p2.setBikeList(bikeList2);
		
		session.persist(p1);
		session.persist(b1);
		session.persist(b2);
		
		session.persist(p2);
		session.persist(b3);
		session.persist(b4);
		
		ts.commit();
		
		session.close();
		sessionFactory.close();
	}
}
