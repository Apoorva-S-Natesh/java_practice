import java.util.Map;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.IdentityHashMap;

public class CollectionWeakHashMap {

	public static void main(String[] args) {
	
		//creatin 4 String objects
		String k1 =new String ("key1");
		String v1 =new String ("Value1");
		String k2 =new String ("Key2");
		String v2 =new String ("Value2");
		
		//Stroring the string objects as key value pairs in a map
		Map <String, String> map = new HashMap<>();
		map.put(k1, v1);
		map.put(k2, v2);
		System.out.println("Map before changes is : " + map);

		//What happens if we delete a key or make it null?
		k1=null;
		System.gc(); //Request garbage collector 
		//Pause to let garbage collection work
		try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
		//Not as expected, the map remains the same. No changes even after making the k1 as 		null, stillshows key1 only.
		System.out.println("Map after changes is: " + map);	


		//We need to use a WEakHashMap, which doesnt hold on tightly to its keys.
		WeakHashMapExample.example();

		//IdentityHashMapExample.example();	
	}
}

class WeakHashMapExample{
	//Map that doesnt hold on tightly to its keys.If there's no other reference to a key outside of  the map, that key-value pair pac be removed by the garbage collector.

	public static void example() {
		Map <Object, String> map = new WeakHashMap<>();
		Object key1 = new Object();
		Object key2 = new Object();
		map.put(key1, "Spicy grilled chicken - today's speacial");
		map.put(key2, "Spicy Veg burger - today's meal Special");
		
		System.out.println("Before Garbage Collection " + map);
		key1 = null; //Removing strong reference to key1
		System.gc(); //Request garbage collector 	

		//Pause to let garbage collection work
		try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
		System.out.println("After GC: " + map);
	}
}

class IdentityHashMapExample 
{
	//Compares keys by their referencce, not by their value. Helps track distinct objects, even if they look the same. Skips the usual equals() and hashCode() methds for comparisions.
	public static void example()
	{
		Map <String, String> restaurantMap = new IdentityHashMap<>();
		String restaurant1 = new String("Burger King");
		String restaurant2 = new String("Burger King");
	
		restaurantMap.put(restaurant1, "Rating: 4.5");
		restaurantMap.put(restaurant2, "Rating 4.7");

		System.out.println("IdentityHashMap: " + restaurantMap);

	}
}
