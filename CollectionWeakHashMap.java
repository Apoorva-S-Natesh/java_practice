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
	}

}