import java.util.*;

class CollectionSet {
	public static void main(String[] args)
	{
		//CollectionTreeSet();
		CollectionHashset();
		CollectionLinkedHashset();
		HastSetOperation.operations();
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

class HastSetOperation {
	public static void operations() 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of initial elements in set");
		int n1 = scan.nextInt();
	
		HashSet <Integer> first = new HashSet<>();
		System.out.println("Enter number present in initial set");
		for (int i=0; i< n1; i++)
			first.add(scan.nextInt());
		System.out.println("Perform operations or type stop");
		while (true)
		{	
			//GIve an operation like ADD number || REMOVE number || PRINT || STOP || CHECK number
			String [] operation = scan.nextLine().split("\\s+");
			if (operation[0].equalsIgnoreCase("STOP"))
				break;
			else if (operation[0].equalsIgnoreCase("PRINT"))
				System.out.println(first);
			else if (operation[0].equalsIgnoreCase("ADD"))
				first.add(Integer.parseInt(operation[1]));
			else if (operation[0].equalsIgnoreCase("REMOVE"))
			{
				if (first.contains(Integer.parseInt(operation[1])))
					first.remove(Integer.parseInt(operation[1]));
			}
			else if (operation[0].equalsIgnoreCase("CHECK"))
			{
				if (first.contains(Integer.parseInt(operation[1])))
					System.out.println("Number Present");
				else
					System.out.println("Number Not Present");
			}
		}
	}
}
