// To run the program, open cmd, go to the folder.
// run: javac Anagrams.java
// once compiled without errors, run: java Anagrams

import java.util.Scanner;
import java.util.Arrays;

class Anagrams {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();
		
		System.out.print("Are the strings anagrams? "); 
		/* The time complexity for this approach is :
		O(m*log(m) + n*log(n)), where m and n are length of string str1 and str2 respectively.
Auxiliary Space: O(1) where the strings are mutable but O(n) in languages like Java, Python, C#, etc. where strings are immutable.
		char [] arr1 = str1.toCharArray();
		char [] arr2 = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if (str1.length() != str2.length()) {
			System.out.println("false");
		 } else {
			if  (Arrays.equals(arr1, arr2)) {
				System.out.println("true");
			 } else {
				System.out.println("false");
			}
		}
		*/
		System.out.println(checkAnagrams(str1, str2));
	}

	/* Time Complexity: O(m + n), where m and n are length of string str1 and str2 respectively. */
	static boolean checkAnagrams(String str1, String str2) {
		int[] freq = new int[26];
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		for (int i = 0; i < str1.length(); i++)
		{
			freq[str1.charAt(i) - 'a']++;
		}

		for (int j = 0; j < str2.length(); j++)
		{
			freq[str2.charAt(j) - 'a']--;
		}
		for (int count : freq) {
			if (count != 0)
				return false;
		}
		return true;
	}
	/* create a frequency array of size 26 by using characters as index in this array. 
	The frequency of ‘a’ is going to be stored at index 0, ‘b’ at 1, and so on. To find 
	the index of a character, we subtract character a’s ASCII value from the ASCII value of the character. 


Count character frequency in the first string, then for each character in the second 
string, decrement its count from the frequency array. If the strings are anagrams, 
all positions in the frequency array will be zero. Any non-zero position means the 
frequency of that character is not equal in both the strings. */
}