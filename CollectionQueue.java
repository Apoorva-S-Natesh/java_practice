import java.util.*;

class CollectionQueue {
	public static void main(String[] args)
	{
		ArrayDeque queue = new ArrayDeque(); 
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
	}
}