package com.string;

/*
* Funny Reverse
*
* in:   "Hello, my new go program!"
* out:  "margorp, og wen ym olleH!"
*/

public class ReverseString {

	public static void main(String[] args) {
		String input = "Hello, my new go program!";
		String output = reverse(input);
		System.out.println(output);

	}

	private static String reverse(String input) {
		if (input == null || input.length() == 0)
			return "";

		StringBuilder result = new StringBuilder();

		String[] words = input.split(" ");
		for (int i = 0; i < words.length; i++) {
			StringBuilder reverseString = new StringBuilder(words[i]).reverse();
			char punctChar = reverseString.charAt(0);
			if (!Character.isAlphabetic(reverseString.charAt(0))) {
				reverseString = reverseString.deleteCharAt(0);
				reverseString.append(punctChar);
			}
			reverseString.append(" ");
			result.append(reverseString);
		}

		return result.toString();
	}

	private static String reverse2(String input) {
		if (input == null || input.length() == 0)
			return "";

		char[] chars = input.toCharArray();
		int start = 0;
		int end = chars.length - 1;
		while (start < end) {
			if (!Character.isAlphabetic(chars[start]))
				start++;
			else if (!Character.isAlphabetic(chars[end]))
				end--;
			else {
				char temp = chars[start];
				chars[start] = chars[end];
				chars[end] = temp;
				start++;
				end--;
			}
		}
		return new String(chars);
	}
}