import java.util.Scanner;

class SortingAlgorithms 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		//taking input from user
		System.out.println("What is the length of the array");
		int n = scan.nextInt();
		int [] arr = new int[n];
		System.out.println("Enter the elements of the array");
		for (int i = 0; i < n ; i++)
		{
			arr[i] = scan.nextInt();
		}

		//calling the sorting algorithm
		bubbleSort(arr, n);

		scan.close();
	}

	static void bubbleSort(int[] arr, int n)
	{
		for (int i = 0; i < n-1; i++)
		{
			for (int j = 0; j < n-i-1; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j+1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		//Printing the sorted array
		System.out.println("Sorted Array");
		for (int num : arr)
			System.out.print(num + " ");
	}
}