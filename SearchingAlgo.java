import java.util.Scanner;
import java.util.Arrays;

class SearchAlgo {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		int n = scan.nextInt();
		System.out.println("Enter the elements of the array");
		int [] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println("Enter the number(key) to be searched");
		int key = scan.nextInt();
		linearSearch(arr, key);
		System.out.println();
		binarySearch(arr, key);

		scan.close();
	}

	static void linearSearch(int[] arr, int key) 
	{
		System.out.println("Linear Search");
		for (int i = 0; i < arr.length; i++)
		{
			if (key == arr[i])
			{
				System.out.println("Key found at " +(i+1)+ " position in the array");
				System.out.println("Number of iterations: " + (i+1));
				return;
			}
		}
		System.out.println("Key not found after " + arr.length + " number of iterations");
	}

	static void binarySearch(int[] arr, int key)
	{
		System.out.println("Binary Search");
		Arrays.sort(arr);
		int low = 0, high = arr.length-1, count=1;
		while (low <= high) {
			int mid = (low+high)/2;
			if (key == arr[mid])
			{
				System.out.println("Key found, key is the " +(mid+1) + " element of the array");
				System.out.println("Number of iterations: " + count);
				for (int ele : arr)
					System.out.print(ele + " ");
				return;
			}
			else if (key > arr[mid])
			{
				low = mid+1;
			}
			else
			{
				high = mid - 1;
			}
			count++;	
		}
		System.out.println("Key not found after " + count + " number of iterations");
	}
}