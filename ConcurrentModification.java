import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

//All the collections are fail-fast classes. When trying concurrency they fail fast.

class ConcurrentModificaion 
{
	public static void main(String[] args)
	{
		ArrayList <Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println(list);
/*Trying to access an ArrayList and adding an element at the same time is called concurrency. concurrency is not supported by a simple for loop*/
		
		/*Enters an infinite loop if we try to accesss and add an element at the same time */
		/*
		for (int i=0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
			list.add(99);
		}
		*/
		

		/*Advanced for loop for Concurrency - prints the first element then throws a ConcurrentModidicationExcemption at te line where we are using add. Noerror at compilation. This property of advanced for loop and Iterator is called as fail-fsat*/
		/*
		for (Integer i : list)
		{
			System.out.println(i);
			list.add(99);
		}
		*/
		/*Exception in thread "main" java.util.ConcurrentModificationException
        at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
        at ConcurrentModificaion.main(ConcurrentModification.java:26)*/


		/*Using Iterator for Concurency*/
		/*
		Iterator <Integer> i = list.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
			list.add(99);
		}
		*/
/*Exception in thread "main" java.util.ConcurrentModificationException*/

		/*Need to use the concurrent classes to somewhat achieve this*/
		CopyOnWriteArrayList <Integer> list1 = new CopyOnWriteArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		System.out.println("Before concurrent modification" + list1);
		for (Integer i : list1)
		{
			System.out.println(i);
			list1.add(99);
		}
		System.out.println("After concurrent modification" +list1); // Output:  After concurrent modification[10, 20, 30, 40, 99, 99, 99, 99]
		/*Instead of modifying the original lsit, a copy will be created and the modifications will be done on the copy if the list. 
  		For all the collections present in the concurrent class like - copyOnWriteArrayList,  ConcurrentHashMap, ConcurrentLinkedQueue. 
    		All the collections in the java.util.Collection are fail-fast classes. */
	}
}
