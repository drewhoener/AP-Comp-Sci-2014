package me.drewhoener.compsci.advanced;

public class RecursionTesting {
	public static void main(String[] args) {

		RecursionTesting rt = new RecursionTesting();

		System.out.println(rt.isPalindrome("racecar"));
		System.out.println(rt.isPalindrome("a"));
		System.out.println(Integer.toBinaryString(13));
		System.out.println(rt.weirder(3, 2));

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

	public int weirder(int r, int s) {

		if (r == 0 || r == s) {

			return 1;

		} else {

			return weirder(r - 1, s) + weirder(r - 1, s - 1);

		}

	}

}
