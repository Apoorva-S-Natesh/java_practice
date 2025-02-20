import java.util.Scanner;

class ArrayExercise {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String [] input = sc.nextLine().split("\\s+");
		int [] arr = new int[input.length];
		for (int i=0; i < arr.length; i++) 
		{
			arr[i] = Integer.parseInt(input[i]);
		} 
		int largestnum = findLartgestNum(arr);
		int sum = findSum(arr);
		System.out.println("Largest number: " + largestnum);
		System.out.println("Sum : " + sum);

		sc.close();	
	}

	static int findLartgestNum(int [] array)
	{
		int max = array[0];
		for (int i =1; i < array.length; i++)
		{
			if (array[i] > max)
				max = array[i];
		}
		return (max);				
	}

	static int findSum(int [] array)
	{
		int sum = 0;
		for (int i =  0; i < array.length; i++)
		{
			sum += array[i];
		}
		return (sum);	
	}

//Split array largest sum - Painter's question
/* split the given array into k sub arrays such that the max sum of the elements is minimized */
//Split the arrray into sub arrays using combinations, then find sum of the elements of that array and find the minimum,  the minimum sum is the answer
	
}