package me.drewhoener.compsci.advanced;

public class RecursionTesting {
	public static void main(String[] args) {

		RecursionTesting rt = new RecursionTesting();

		System.out.println(rt.isPalindrome("racecar"));
		System.out.println(rt.isPalindrome("a"));
		System.out.println(Integer.toBinaryString(13));

	}

	public boolean isPalindrome(String s) {

		return s.equalsIgnoreCase(reverseString(s));

	}

	public String reverseString(String input) {

		String reverse = "";
		char[] chars = input.toLowerCase().toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {

			reverse += chars[i];

		}

		return reverse;

	}

}
