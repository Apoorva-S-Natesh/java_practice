import java.util.*;

public class Generics{
	public static void main(String[] args)
	{
		MyPrinter <Integer> ip = new MyPrinter();
		ip.printData(90);
		MyPrinter <String> sp = new MyPrinter();
		sp.printData("String");
		printValue(100);
		printValue(100.1909);
		printValue("Hello");
		printValue(true);

		printanyValue(100);
		printanyValue(100.1909);
		printanyValue("Hello");
		printanyValue(true);

		List <String> nameList = new LinkedList<String>();//Polymorphism
		nameList.add("Apple");
		nameList.add("Banana");
		nameList.add("Mango");
		nameList.add("Cherry");
		//nameList.add(10.9);
		System.out.println(nameList);
	}

	public static void printValue(Object val)
	{
		System.out.println(val);
	}

	public static <T> void printanyValue(T val)
	{
		System.out.println(val);
	}
}
		

class MyPrinter <T> 
{
	public void printData(T  val)
	{
		System.out.println(val);
	}
}

/*
Generics is a feature in Java that allows you to write code that can work with any data type. Instead of specifying a particular datatype in advance you use a type parameter that stands in for the actual type. This make the classes and methods flexible and reusable for any kind of object.
*/