import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;
import java.util.*;

class ComparatorJava {
	public static void main(String [] args) {
		ArrayList <Integer> nums = new ArrayList<>();
		nums.add(20);
		nums.add(50);
		nums.add(10);
		nums.add(30);
		nums.add(50);
		System.out.println(nums);
		// for (int i = 0; i < nums.size() -1 ; i++)
		// {
		// 	if (nums.get(i) > nums.get(i+1))
		// 	{
		// 		Integer temp = nums.get(i);
		// 		nums.add(i, nums.get(i+1));
		// 		nums.add((i+1), temp);
		// 	}
		// }
		// System.out.println(nums);
		/*>Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.base/java.util.Arrays.copyOf(Arrays.java:3512)
        at java.base/java.util.Arrays.copyOf(Arrays.java:3481)
        at java.base/java.util.ArrayList.grow(ArrayList.java:238)
        at java.base/java.util.ArrayList.grow(ArrayList.java:245)
        at java.base/java.util.ArrayList.add(ArrayList.java:516)
        at ComparatorJava.main(ComparatorJava.java:18)*/


		//Method 1
		Collections.sort(nums);
		System.out.println(nums);

		//Method 2
		TreeSet n = new TreeSet();
		n.addAll(nums);
		System.out.println(n);


		//For complex collection objects
		Student s1 = new Student(10, "Hello", 8.5f);
		Student s2 = new Student(5, "Mello", 6.5f);
		Student s3 = new Student(2, "Jello", 9.5f);
		Student s4 = new Student(15, "Bello", 5.5f);

		ArrayList <Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		System.out.println("Original List" + students);

		//Collections.sort(students);
		/*  error: no suitable method found for sort(ArrayList<Student>)
                Collections.sort(students);
                           ^
    method Collections.<T#1>sort(List<T#1>) is not applicable
      (inference variable T#1 has incompatible bounds
        equality constraints: Student
        upper bounds: Comparable<? super T#1>)
    method Collections.<T#2>sort(List<T#2>,Comparator<? super T#2>) is not applicable
      (cannot infer type-variable(s) T#2
        (actual and formal argument lists differ in length))
  where T#1,T#2 are type-variables:
    T#1 extends Comparable<? super T#1> declared in method <T#1>sort(List<T#1>)
    T#2 extends Object declared in method <T#2>sort(List<T#2>,Comparator<? super T#2>) */
		//System.out.println(students);

		//Use compareTo method for such objects from Comparable interface (so Student class implements Comparable interface which is a functional interface(only 1 function inside))
		//Collections.sort(students);
		// for (Student s :students)
		// 	System.out.println(s);


		//When The target class (Student class) is not accessible to the programmer so we cannot write anything in the Student class 
		//In this case we need to use a Comparator

		Organiser organiser = new Organiser();
		Collections.sort(students, organiser);
		System.out.println("Sorted list: "+ students);

		//Using Anonymous class(instantiated and used all in one go)
		students.sort(new Coparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return Integer.compare(s1.cgpa, s2.cgpa);
			}
		});
		System.out.println("Sorted by cgpa: " + students);
	}
}

class Organiser implements Comparator {
	
	@Override
	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;

		if (s1.cgpa > s2.cgpa)
			return 1;
		else if (s1.cgpa < s2.cgpa)
			return -1;

		return 0;
	}
}

//class Student implements Comparable
class Student

{
	int roll;
	String name;
	float cgpa;

	public Student(int roll, String name, float cgpa)
	{
		this.roll = roll;
		this.name = name;
		this.cgpa = cgpa;
	}

	@Override
	public String toString()
	{
		return ("Student[name='"+name+"', roll="+roll+", cgpa="+cgpa+"]");
	}


	//uncomment any one of the below overridden method based on what sorting needs to be done
	// //Sorting based on roll number in descending order
	// @Override
	// public int compareTo(Object o)
	// {
	// 	Student st = (Student)o;
	// 	if (this.roll > st.roll)
	// 		return -1;
	// 	else if (this.roll < st.roll)
	// 		return 1;
	// 	return 0;
	// }

	//Sorting based on cgpa in ascending order
	// @Override
	// public int compareTo(Object o)
	// {
	// 	Student st = (Student)o;
	// 	if (this.cgpa > st.cgpa) //first object > second object 
	// 		return 1;			//Returning a postivie value
	// 	else if (this.cgpa < st.cgpa)
	// 		return -1;
	// 	return 0;				//first object = second object
	// }

	//Sorting based on name in dictionary order
	// @Override
	// public int compareTo(Object o)
	// {
	// 	Student st = (Student)o;
	// 	return(this.name.compareTo(st.name)); //String.compareto() which compare strings lexicographically
	// }
}

/* There are three variants of the compareTo() method which are as follows:

Using int compareTo(Object obj)
Using int compareTo(String AnotherString)
Using int compareToIgnoreCase(String str)  */

