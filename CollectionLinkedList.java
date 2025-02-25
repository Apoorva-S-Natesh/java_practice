import java.util.Scanner;
import java.util.LinkedList;

class CollectionLinkedList
{
	public static void main(String[] args)
	{
		System.out.println("Welcome");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		sc.nextLine();
		LinkedList <Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++)
		{
			//list.addFirst(sc.nextInt());
			list.addLast(sc.nextInt());
		}
		System.out.println(list);
		list.set(1, 50);
		list.removeFirst();
		list.removeLast();
		System.out.println(list);

		list.remove(1);
		System.out.println(list);

		sc.close();
	}
}