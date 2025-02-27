import java.util.*;

public class WildcardsGenerics
{
	public static void main(String[] args)
	{
		Student st = new Student(1, "Apoorva");
		System.out.println(st); //Student@24d46ca6 - hash code(address) value of the reference variable of the object
		System.out.println(st.toString()); //toString defined in Object class - to print the addess(hash code) of the object.
		System.out.println(st.toString()); // 1-Apoorva - Overridden method
		Student st2 = new Student(2, "Natesh");
		System.out.println(st2.toString());

		List <Integer> intList = new ArrayList<Integer>();
		intList.add(200);
		intList.add(100);
		intList.add(50);
		printList(intList);
		Student st3 = new Student (3, "Lakshmi");
		Student st4 = new Student (4, "Anani");
		List <Student> studentList = new ArrayList<>();
		studentList.add(st3);
		studentList.add(st4);
		System.out.println(studentList);

		Fresher f1 = new Fresher(101, "Jay");
		Fresher f2 = new Fresher(101, "Apoo");
		List <Fresher> FresherList = new ArrayLsit<Fresher>);
		FresherList.add(f1);
		FresherList.add(f2);
		printList(FresherList);		

		Mentor m1 = new Mentor(101, "Jay");
		Mentor m2 = new Mentor(102, "Joy");
		List <Mentor> mentorList = new ArrayLsit<Mentor>);
		mentorList.add(m1);
		mentorList.add(m2);
		printList(mentorList);
	}

/*Wild card generics represented by ? It means that the specific type is not the concern as long as it data can be read. This indicates that this method will accept a list of any type. Makes the code flexible */
// Unbounded Wildcards: ?
	public static void printList(List<?> list)
	{
		for(Object element: list)
		{
			System.out.println(element);
		}
	}

	//Upperbounded wildcards
	public static void printList(List<? extends Fresher> list)
	{
		for(Object element: list)
		{
			System.out.println(element);
		}
	}
	/*All the child classes of the Fresher this will work.
	When we want something to work for one kind of items(child class items) we can use upperbound*/

	/*Lowerbound wildcard - It will work for Stundent and parent class of student - works for Parent and child relationship*/
	public static void printList(List<? super Student> list)
	{
		for(Object element: list)
		{
			System.out.println(element);
		}
	}
}

classFresher {

}

class Student extends Fresher {
	int roll;
	String name;
	public Student(int roll, String name)
	{
		super();
		this.roll = roll;
		this.name = name;
	}

	public String toString() { //Overriding the methond from Object class
		return roll + "-" + name;
	}
}

class Mentor {
	int id;
	String name;
	public Mentor(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String toString() { //Overriding the methond from Object class
		return id + "-" + name;
	}
}