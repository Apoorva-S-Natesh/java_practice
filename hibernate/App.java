package learn.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Student st = new Student(4, "Swara", "Amsterdam", 2035);
    	
    	Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); //Specifying where the configuration file is located
        SessionFactory factory = cfg.buildSessionFactory();
        //System.out.println(factory);
        Session session = factory.openSession(); // Create a session 
        
        //addData(session, st);
        //fetchData(session, 2);
        updateData(session, st);
        //deleteData(session, 4);
        
    }
    
    public static void addData(Session session, Student st) {
    	Transaction tx = session.beginTransaction(); // Create a transsaction
    	session.persist(st); // Insert the data, save is depricated
    	
        tx.commit(); // Commit the transaction 
    }
    
    /*
     * For Updating 1.Fetch the data from database 2. Update the data and send it
     * back to the database to be saved
     */
    public static void fetchData(Session session, int id) {
    	Student st = session.get(Student.class, id); // 2 is the PrimaryKey // HQL - Hibernate: select s1_0.kodId,s1_0.address,s1_0.name,s1_0.yop from Student s1_0 where s1_0.kodId=?
        System.out.println(st); // Student [kodId=2, name=Anu, address=Eindhovan, yop=2015] 
    }
    
    /*
     * Update the data: First fetch the data from Database and then set the update and do the update transaction
     * */
    public static void updateData(Session session, Student student) {
    	//Student student = session.get(Student.class, 2);
    	student.setYop(2021);
    	
    	Transaction tx = session.beginTransaction();
    	session.merge(student);
    	tx.commit();
    }
    
    public static void deleteData(Session session, int id) {
    	Student st = session.get(Student.class, id);
    	
    	Transaction tx = session.beginTransaction();
    	session.remove(st);
    	
    	tx.commit();
    }
}

/*
 * When the same program is run twice without changing the Student object details we get this error:
ERROR: Duplicate entry '1' for key 'student.PRIMARY'
Exception in thread "main" org.hibernate.exception.ConstraintViolationException: could not execute statement [Duplicate entry '1' for key 'student.PRIMARY'] [insert into Student (address,name,yop,kodId) values (?,?,?,?)]
 * 
 * As Id is specified as a primary key and primary key cannot have duplicates.
 * 
 * 
 * Hibernate uses HQL(Hibernate Query Language)
 * List <USer> users = session.createQuery("FROM User", use.class).list() - fetching all records from a table
 * */
