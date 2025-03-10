import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

class CollectionsMethods 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		ArrayList <Integer> marks = new ArrayList<>();
		
		System.out.println("Enter space separated integers");
		String input = sc.nextLine().trim();
		for (String s : input.split("\\s+"))
		{
			marks.add(Integer.parseInt(s));
		}
		
		//Collections.sort() - sorts the elements in ascending order by default. use Comparator.reverseOrder() - to sort in descending order.

		Collections.sort(marks, Comparator.reverseOrder());
		System.out.println("Sorted marks (Descending): " + marks);

		Collections.sort(marks);
		System.out.println("Sorted marks (Ascending): " + marks);

		//Collections.binaySearch() - to search elements in sorted lists. Returns index, if not returns a negative value indicating insertion point
		System.out.println("Enter a number to search");
		int target = sc.nextInt();
		int index = Collections.binarySearch(marks, target);

		if (index >= 0)
			System.out.println("the number " + target + " is found at index " + index);
		else
			System.out.println("The number not found, can be inserted at " + index); 

		sc.nextLine();
		//Collections.reverse() - to invert the order of elemetns in a list, It operates in-place, modifying the original list

		ArrayList <String> colors = new ArrayList<>();
		System.out.println("enter 5 colors in new line");
		for (int i =0; i < 5 ; i++)
		{
			colors.add(sc.nextLine());
		}
		Collections.reverse(colors);
		System.out.println(colors);

		//Collections.frequency() - to count occurrences of a specific element in a list. if not found returns 0
		int count = Collections.frequency(colors, "red");
		System.out.println("Frequency of 'red' " + count);

		//Collections.disjoint() - to check if two lists have overlap or are disjoint.returns tru if no overlap, false if overlap is present
		ArrayList <String> colors2 = new ArrayList<>();
		Collections.addAll(colors2, "red", "green", "orange", "yellow", "brown");
		boolean isDisjoint = Collections.disjoint(colors, colors2);
		System.out.println(isDisjoint);

		//Collections.max() and //Collections.min() to find the max and min element from the collection based on natural ordering

		sc.close();
	}
}

		