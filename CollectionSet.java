import java.util.*;

class CollectionSet {
	public static void main(String[] args)
	{
		//CollectionTreeSet();
		CollectionHashset();
		CollectionLinkedHashset();
	}

	static void CollectionTreeSet()
	{
	//Removes the duplicates and even sorts the data unlike the Lists where duplicates are allowed and data is not sorted
		TreeSet coll = new TreeSet();
		coll.add(20);
		coll.add(10);
		coll.add(40);
		coll.add(20);
		//coll.add("java"); Doesnt allow heterogenous data 
		coll.add(20);
		coll.add(40);
		System.out.println(coll);

		coll.remove(10);
		System.out.println(coll);
		if (coll.contains(20))
			System.out.println("20 is present");
		else
			System.out.println("20 is not present");

		if (coll instanceof TreeSet)
		{
			TreeSet<Integer> treeSet = (TreeSet<Integer>) coll;
			System.out.println("FIrst Element:" + treeSet.first());
			System.out.println("Last Element:" + treeSet.last());
		}

		//does not support index, foreach loop required for traversing
	}

	static void CollectionHashset() {
		Set  techTools= new HashSet();
		//adding elements
		techTools.add("Git");
		techTools.add("Python");
		techTools.add("Java");
		techTools.add("Docker");
		techTools.add("Git"); //Duplicate elements will not be added
		

		//Displaying the elements(order may vary)
		System.out.println("Tech tools: " +techTools);

		//Removing an element
		techTools.remove("Docker");
		System.out.println("After removing Docker:" + techTools);

		//Checking if an element exists
		if (techTools.contains("Git"))
		{
			System.out.println("git is in techTools");
		}

		//Allows heterogenous data 
		techTools.add(20);
		System.out.println("Allows heterogenous data" + techTools);
	}

	static void CollectionLinkedHashset() {
		Set  techTools= new LinkedHashSet();
		//adding elements
		techTools.add("Git");
		techTools.add("Python");
		techTools.add("Java");
		techTools.add("Docker");
		techTools.add("Git"); //Duplicate elements will not be added
		
		//Dsplaying the elements(order doesnt vary, order is maintained)
		System.out.println("Tech tools: " +techTools);

		//Removing an element
		techTools.remove("Docker");
		System.out.println("After removing Docker:" + techTools);

		//Checking if an element exists
		if (techTools.contains("Git"))
		{
			System.out.println("git is in techTools");
		}

		//Allows heterogenous data 
		techTools.add(20);
		System.out.println("Allows heterogenous data" + techTools);
	}
}
