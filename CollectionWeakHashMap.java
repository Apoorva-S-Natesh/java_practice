import java.util.Map;
import java.util.WeakHashMap;

public class CollectionWeakHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <Object, String> map = new WeakHashMap<>();
		Object key1 = new Object();
		map.put(key1, "Spicy grilled chicken - today's speacial");
		
		System.out.println("Before Garbage Collection " + map);
		key1 = null; //Removing strong reference to key1
		System.gc(); //Request garbage collector 	

		//Pause to let garbage collection work
		try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
		System.out.println("After GC: " + map);	
		
		IdentityHashMapExample.example();	
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
