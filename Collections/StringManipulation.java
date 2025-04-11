import java.util.Scanner;

class StringManipulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//reverseString(str);
		//checkPalindrome(str);
		toLowerCase(str);
		toUpperCase(str);
		sc.close();
	}

	public static void reverseString(String str) {
		char [] str1 = str.toCharArray();
		int count = str1.length;
		char [] arr = new char[count];
		int j = count -1;
		for (int i = 0; i < count; i++) {
			arr[i] = str1[j];
			j--;
		}
		String str2 = new String(arr);
		System.out.println("The length is :" + count);
		System.out.println("The reversed string is: " + str2);
	}

	static void checkPalindrome(String str) {
		char[] arr = str.toCharArray();
		int count = arr.length;
		char[] rev = new char[count];
		int j = count-1;
		for(int i = 0; i < count; i++) {
			rev[i] = arr[j];
			j--;
		}
		String revString = new String(rev);
		System.out.println("The reversed string is: " + revString);
		if (str.equals(revString)) {
			System.out.println("Word is a Palindrome");
		} else
			System.out.println("Word is not a palindrome");
	}
	
	static void toLowerCase(String str) {
		char [] arr = str.toCharArray();
		char [] lower = new char[arr.length];
		for (int i = 0 ; i < arr.length; i++) {
			if (arr[i] >= 65 && arr[i] <= 90) {
				lower[i] = (char)(arr[i] + 32);
			}
			else
				lower[i] = arr[i];
		}
		String lowerStr = new String(lower);
		System.out.println("The string in lower case is : " + lowerStr);
	}

	static void toUpperCase(String str) {
		char [] arr = str.toCharArray();
		char [] upper = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 97 && arr[i] <= 122)
				upper[i] = (char)(arr[i] - 32);
			else
				upper[i] =arr[i];
		}
		String upperCase = new String(upper);
		System.out.println("The string in upper case is: " + upperCase);
	}
}
		