package practice.manyToOne;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person {
	@Id
	int id;
	String name;
	@OneToMany (cascade = CascadeType.ALL)// One person to many bikes, cascade -means if person is saved or deleted all the course will be handled automatically
	List<Bike> bikeList;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, List<Bike> bikeList) {
		super();
		this.id = id;
		this.name = name;
		this.bikeList = bikeList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Bike> getBikeList() {
		return bikeList;
	}
	public void setBikeList(List<Bike> bikeList) {
		this.bikeList = bikeList;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", bikeList=" + bikeList + "]";
	}
}
