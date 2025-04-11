import java.util.Scanner;

class LongestSubString {
   	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        		System.out.println("Enter a string:");
        		String s = scanner.nextLine();
        		scanner.close();

        		// Array to store the last index of each character seen in the string
        		// Assuming the input string can include any ASCII character
        		int[] last = new int[128]; // ASCII table size
        		for (int i = 0; i < last.length; i++) 
		{
            			last[i] = -1; // Initialize with -1 indicating that we haven't seen this character
       		}

        		int maxLen = 0;
        		int start = 0; // Start index of the current substring without repeating characters

        		for (int i = 0; i < s.length(); i++) 
		{
            			// Find the last position of s[i]
            			if (last[s.charAt(i)] >= start) 
			{
                				start = last[s.charAt(i)] + 1; // Move the start up to the next index after the last occurrence
            			}

           			 // Calculate the maximum length of substring
            			maxLen = Math.max(maxLen, i - start + 1);
            			// Update the last seen index of the character s[i]
            			last[s.charAt(i)] = i;
        		}

        		System.out.println("The length of the longest substring without repeating characters is: " + maxLen);
    	}
}

/* Sliding WIndow Method

Explanation:

We use an integer array last to keep track of the last index at which each character appears. This array works for ASCII characters, which are sufficient for many cases unless your input can include characters outside the ASCII range.
As we iterate through the string s, we check if the current character was seen in the current window (from start to i). If it was, we move the start of the window to the character after its last appearance.
We always update the maximum length found so far and the last occurrence index of the current character.


Walkthrough with "abcaabcdba"
Initial: last = [-1, -1, -1, ..., -1], start = 0, maxLen = 0.
i = 0 (a): last[a] = -1, set last[a] = 0, maxLen = 1.
i = 1 (b): last[b] = -1, set last[b] = 1, maxLen = 2.
i = 2 (c): last[c] = -1, set last[c] = 2, maxLen = 3.
i = 3 (a): last[a] = 0 and 0 >= 0, move start to 1, set last[a] = 3, maxLen = 3.
i = 4 (a): last[a] = 3 and 3 >= 1, move start to 4, set last[a] = 4, maxLen = 3.
i = 5 (b): last[b] = 1 and 1 >= 4, no change to start, set last[b] = 5, maxLen = 3.
i = 6 (c): last[c] = 2 and 2 >= 4, no change to start, set last[c] = 6, maxLen = 3.
i = 7 (d): last[d] = -1, set last[d] = 7, maxLen = 4.
i = 8 (b): last[b] = 5 and 5 >= 4, move start to 6, set last[b] = 8, maxLen = 4.
i = 9 (a): last[a] = 4 and 4 >= 6, no change to start, set last[a] = 9, maxLen = 4.
*/

