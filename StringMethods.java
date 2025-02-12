class StringMethods {
	public static void main(String [] args) {
		String str = "KodNest Tech";
		System.out.println(str.toUpperCase()); // KODNEST TECH
		System.out.println(str.toLowerCase()); // kodnest tech
		System.out.println(str.charAt(2)); //d
		System.out.println(str.indexOf('T')); //8
		System.out.println(str.startsWith("Kod")); //true
		System.out.println(str.endsWith("Tech")); // true
		System.out.println(str.contains("Ne")); // true
		System.out.println(str.contains("N")); // true
		System.out.println(str.isEmpty()); //false
		System.out.println(str.length()); // 12
		System.out.println(str.substring(0,4)); // KodN
		System.out.println(str.replace('e', 'a')); // KodNast Tach
		System.out.println(str.indexOf('e')); // 4
		System.out.println(str.lastIndexOf('e')); // 9
		System.out.println(str.concat(" Pvt Ltd.")); // KodNest Tech Pvt Ltd.
	}
}