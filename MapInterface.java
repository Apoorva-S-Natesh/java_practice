import java.util.*;

class MapInterface{
	public static void main(String[] args) 
	{
		hashMap();
		treeMap();
		linkedHashMap();
	}

	
	public static void hashMap()  // When the order does not matter
	{
		Map <String, Integer> productMap = new HashMap<>();

		//put() method to add key-value pairs to the HashMap
		productMap.put("Laptop", 1500);
		productMap.put("Phone", 900);
		productMap.put("Tablet", 1000);
		productMap.put("Watch", 500);
		System.out.println(productMap);		

		//get() method retrieves the value associated with a specific key.
		int price = productMap.get("Phone");
		System.out.println("Price of phone: " + price);

		//remove() method removes the key-value pair for the specific key
		productMap.remove("Tablet");

		//containsKey() checks if a specifc key exists in the HashMap
		boolean hasLaptop = productMap.containsKey("Laptop");
		System.out.println("Contains Laptop: " + hasLaptop);

		//keySet() method returns a set of view of all keys in HashMap
		Set<String> keys = productMap.keySet();
		System.out.println("Keys: " + keys);
		

		//values() - returns a colection view of all the values in the HashMap
		Collection <Integer> values = productMap.values();
		System.out.println("Values: " + values);

		//Returns a Collection of key=value
		Set p = productMap.entrySet();
		System.out.println(p);

		//Another way to access using forEach loop
		productMap.forEach((na, pr) -> System.out.println("Price: " + pr + ", Name: " + na));

		//yet another way to iterate over the elements
		Iterator<Map.Entry<String, Integer>> iterator = productMap.entrySet().iterator();
		while (iterator.hasNext()) 
		{ 
			Map.Entry<String, Integer> entry = iterator.next();
    			System.out.println("Name: " + entry.getKey() + ", Price: " + entry.getValue());
		}

		//Another method using keyset
		for (String name : productMap.keySet()) 
		{
			System.out.println("Name " + name+ ", Price: " + productMap.get(name));
		}

		//both Map and Entry are interfaces. If we used Object then individual access to key and value will not be possible
		for (Map.Entry<String, Integer>product : productMap.entrySet())
            			System.out.println("Key: " + product.getKey() + " Value: " + product.getValue());
	}

	public static void treeMap()  // When the key needs to be in sorted order
	{
		Map <String, Integer> productMap = new TreeMap<>();

		//put() method to add key-value pairs to the HashMap
		productMap.put("Laptop", 1500);
		productMap.put("Phone", 900);
		productMap.put("Tablet", 1000);
		productMap.put("Watch", 500);
		System.out.println(productMap);		

		//get() method retrieves the value associated with a specific key.
		int price = productMap.get("Phone");
		System.out.println("Price of phone: " + price);

		//remove() method removes the key-value pair for the specific key
		productMap.remove("Tablet");

		//containsKey() checks if a specifc key exists in the HashMap
		boolean hasLaptop = productMap.containsKey("Laptop");
		System.out.println("Contains Laptop: " + hasLaptop);

		//keySet() method returns a set of view of all keys in HashMap
		Set<String> keys = productMap.keySet();
		System.out.println("Keys: " + keys);
		

		//values() - returns a colection view of all the values in the HashMap
		Collection <Integer> values = productMap.values();
		System.out.println("Values: " + values);

		for (Map.Entry<String, Integer> e : ProductMap.entrySet())
            			System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
	}

	public static void linkedHashMap()  // When the insertion order needs to be mainted the same
	{
		Map <String, Integer> productMap = new LinkedHashMap<>();

		//put() method to add key-value pairs to the HashMap
		productMap.put("Laptop", 1500);
		productMap.put("Phone", 900);
		productMap.put("Tablet", 1000);
		productMap.put("Watch", 500);
		System.out.println(productMap);		

		//get() method retrieves the value associated with a specific key.
		int price = productMap.get("Phone");
		System.out.println("Price of phone: " + price);

		//remove() method removes the key-value pair for the specific key
		productMap.remove("Tablet");

		//containsKey() checks if a specifc key exists in the HashMap
		boolean hasLaptop = productMap.containsKey("Laptop");
		System.out.println("Contains Laptop: " + hasLaptop);

		//keySet() method returns a set of view of all keys in HashMap
		Set<String> keys = productMap.keySet();
		System.out.println("Keys: " + keys);
		

		//values() - returns a colection view of all the values in the HashMap
		Collection <Integer> values = productMap.values();
		System.out.println("Values: " + values);
	}

	public static String getKeyFromValue(TreeMap<String, String> map, String value) {
    		for (Map.Entry<String, String> entry : map.entrySet()) {
        		if (entry.getValue().equals(value)) {
            			return entry.getKey(); 
       			 }
    		}
    		return null; // Return null if no key matches the value
	}
}
