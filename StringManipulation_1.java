import java.util.Scanner;

class StringManipulation_1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		String newStr = removeDuplicates(str);
		System.out.println("new string : " + newStr); 
		checkFrequency(str, newStr);
		scanner.close();
	}

	static String removeDuplicate(String str) {
		String newStr = "";
		for (int i = 0; i <= str.length()-1; i++) {
			char ch = str.charAt(i);
			if ( ! (newStr.contains(String.valueOf(ch)))) {
				newStr = newStr + ch;
			}
		}
		return newStr;
	}

	static String removeDuplicates(String str) {
		char [] str1 = str.toCharArray();
		char [] arr = new char[str1.length];
		int j = 0;
		for (int i = 0; i < str1.length; i++) {
			boolean isDuplicate = false;
			for (int k = 0; k < j; k++) {
				if (str1[i] == arr[k]) {
					isDuplicate = true;
					break;
				 }
			}
			if (!isDuplicate) {
				arr[j] = str1[i];
				j++;	 
			}
		}
		String newStr = new String(arr);
		return (newStr);
	}

	static void checkFrequency(String str, String newStr) 
	{
		char [] full = str.toCharArray();
		char [] nodup = newStr.toCharArray();

		for (int i = 0; i< nodup.length; i++) 
		{
			if (nodup[i] == '\0')
				continue;
			int count = 0;
			for (int j = 0; j < full.length; j++) 
			{
				if (nodup[i] == full[j])
					count++;	
			}
			System.out.println(nodup[i] + " : " + count);
		}
	}
}