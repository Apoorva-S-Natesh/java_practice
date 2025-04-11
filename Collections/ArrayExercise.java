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
		//int largestnum = findLartgestNum(arr);
		//int sum = findSum(arr);
		//System.out.println("Largest number: " + largestnum);
		//System.out.println("Sum : " + sum);
		
		int result = splitArray(arr, k);
        	System.out.println("The minimized maximum sum is: " + result);
		
		sc.close();	
	}

	public static int splitArray(int[] nums, int k) {
        int low = largestnum(nums); // Minimum possible max sum (largest single element)
        int high = findSum(nums); // Maximum possible max sum (sum of all elements)

        while (low < high) {
            int mid = low + (high - low) / 2; // Mid value as potential max sum
            
            if (canSplit(nums, k, mid)) {
                high = mid; // Try for a smaller maximum sum
            } else {
                low = mid + 1; // Increase min bound as mid was too small
            }
        }

        return low; // The minimized largest sum
    }

// Function to check if we can split the array into k subarrays with max sum ≤ limit
    private static boolean canSplit(int[] nums, int k, int limit) {
        int subarrays = 1, currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > limit) { // If adding num exceeds limit, start new subarray
                subarrays++;
                currentSum = num; // Start new subarray with current number
                if (subarrays > k) { // Too many subarrays
                    return false;
                }
            } else {
                currentSum += num; // Continue adding to the current subarray
            }
        }

        return true; // Successfully split into k or fewer subarrays
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
}

//Split array largest sum - Painter's question
/* split the given array into k sub arrays such that the max sum of the elements is minimized */
//Split the arrray into sub arrays using combinations, then find sum of the elements of that array and find the minimum,  the minimum sum is the answer
/*
Given are N boards of with length of each given in the form of array, and K painters, such that each painter takes 1 unit of time to paint 1 unit of the board. 
The task is to find the minimum time to paint all boards under the constraints that any painter will only paint continuous sections of boards, 
say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
*/
