package com.study.algorithm.site.leetCode;

public class Palindrome {

	public static void main(String[] args) {
		boolean palindrome = isPalindrome(-121);
		boolean palindrome2 = isPalindrome(10);
		System.out.println("palindrome = " + palindrome);
		System.out.println("palindrome2 = " + palindrome2);
	}

	private static boolean isPalindrome(int x) {
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		return sb.reverse().toString().equals(String.valueOf(x));
	}
}
