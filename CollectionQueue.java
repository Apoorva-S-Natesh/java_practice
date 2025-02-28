import java.util.*;

class CollectionQueue {
	public static void main(String[] args)
	{
		//collectionArrayDeque();
		collectionPriorityQueue();
	}

	static void collectionArrayDeque()
	{
		ArrayDeque queue = new ArrayDeque(); //Internal data structure- double headed queue
		queue.add(10);
		queue.add(20);
		queue.add("Hello");
		queue.add(true);
		System.out.println(queue);

		queue.addLast("Last");
		System.out.println(queue);

		queue.addFirst("First");
		System.out.println(queue);

		for (Object ob : queue)
			System.out.println(ob);

		queue.removeLast();
		System.out.println("Last removed" + queue);

		queue.removeFirst();
		System.out.println("First removed : " + queue);

		//queue.get(2); // error : ArrayDeque does not support indices.
		//ArrayDeque uses doubled ended queue

		System.out.println(queue.peek()); // Returns the head element - only retrieves it
		System.out.println(queue);
		System.out.println(queue.poll()); // Returns the head element and also removes it
		System.out.println(queue);
		System.out.println(queue.contains(true));
		System.out.println(queue);
		System.out.println(queue.pop()); //Removes the head
		System.out.println(queue);
	}

	static void collectionPriorityQueue()
	{
		//Priority is the element which is smallest (for string its the dictionay format) - which will be the first element
		//we can only store homogenous type of data, cannot compare double with string
		PriorityQueue <Integer> q = new PriorityQueue<>();

		q.add(30);
		q.add(40);
		q.add(20);
		q.add(10);
		q.add(5);
		q.add(80);
		q.add(25);
		q.add(100);
		System.out.println(q);

		PriorityQueue <String> q1 = new PriorityQueue<>();

		q1.add("aaa");
		q1.add("apoo");
		q1.add("Jaa");
		q1.add("Saaa");
		q1.add("laks");
		q1.add("ccc");
		System.out.println(q1);
		System.out.println(q1.peek()); // Returns the head element - only retrieves it
		System.out.println(q1);
		System.out.println(q1.poll()); // Returns the head element and also removes it
		System.out.println(q1);
		System.out.println(q1.remove()); // Returns the head element and also removes it
		System.out.println(q1);
		System.out.println(q1.contains(true));
		System.out.println(q1);


		PriorityQueue <Integer> q3 = new PriorityQueue<>();

		q3.add(8);
		q3.add(3);
		q3.add(1);
		q3.add(5);
		q3.add(6);
		q3.add(2);
		q3.add(4);
		System.out.println(q3);
	}
}
