package practice.manyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bike {
	@Id
	int modelNum;
	String brand;
	@ManyToOne // Many bike to one person
	Person person;
	
	public Bike() {
		super();
	}

	public Bike(int modelNum, String brand, Person person) {
		super();
		this.modelNum = modelNum;
		this.brand = brand;
		this.person = person;
	}

	public int getModelNum() {
		return modelNum;
	}

	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Bike [modelNum=" + modelNum + ", brand=" + brand + ", person=" + person + "]";
	}
}
