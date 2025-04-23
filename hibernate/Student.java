package learn.hiber;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //whose table has to be created
public class Student {
	@Id //to specify the primary key
	int kodId;
	String name;
	String address;
	int yop;
	
	// All the below are required by hibernate to perform CRUD and best practices to be followed
	
	// Default Constructor
	public Student() {
		super();
	}
	
	// Parameterized constructor
	public Student(int kodId, String name, String address, int yop) {
		this.kodId = kodId;
		this.name = name;
		this.address = address;
		this.yop = yop;
	}
	
	// Setters and getters
	public int getKodId() {
		return kodId;
	}

	public void setKodId(int kodId) {
		this.kodId = kodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	// To String
	@Override
	public String toString() {
		return "Student [kodId=" + kodId + ", name=" + name + ", address=" + address + ", yop=" + yop + "]";
	}
	
	
}