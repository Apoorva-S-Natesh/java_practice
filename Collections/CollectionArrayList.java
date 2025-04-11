import java.util.ArrayList;

class CollectionArrayList
{
	public static void main(String[] args)
	{
		//ArrayList list = new ArrayList();
		//list.add(10);
		//list.add(false);
		//list.add(2.50);
		//list.add("Apoo");
		//System.out.println(list);
		//System.out.println(list.get(2));
		
		ArrayList <String>  veg = new ArrayList<>();
		veg.add(0, "Potato");
		veg.add(1,"Tomato");
		veg.add(0, "Brinjal");
		System.out.println(veg);

		ArrayList fruits = new ArrayList();
		fruits.add("Mango");
		fruits.add("Apple");
		fruits.add("Guava");
		System.out.println(fruits);
	
		ArrayList vegFruits = new ArrayList();
		vegFruits.add(veg);
		vegFruits.add(fruits);
		System.out.println(vegFruits);
		System.out.println(vegFruits.get(1));
		System.out.println(((ArrayList)vegFruits.get(1)).get(1));

		ArrayList   veg_fruits = new ArrayList();
		veg_fruits.addAll(veg);
		veg_fruits.addAll(fruits);
		System.out.println(veg_fruits);
		System.out.println(veg_fruits.lastIndexOf("Apple"));
		System.out.println(veg_fruits.set(5, "Cherry"));
		System.out.println(veg_fruits);
		System.out.println(veg_fruits.get(3));

		veg_fruits.remove(1);
		System.out.println(veg_fruits);
		veg_fruits.removeAll(veg);
		System.out.println(veg_fruits);

		ArrayList <Integer> num = new ArrayList<>();
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);
		num.add(50);
		System.out.println(num);
		for (int i = 0; i < num.size(); i++)
		{
			int n = num.get(i);
			n *= 10;
			System.out.print(n + " ");
		}
		num.add(3, 60); //Inserts the data by shifting the elements and not data is replaced.
		num.set(4,70); // The index at 4 will be replaced by the data sent. The elemtns dont  shift.
		System.out.println(num);
	}
}
