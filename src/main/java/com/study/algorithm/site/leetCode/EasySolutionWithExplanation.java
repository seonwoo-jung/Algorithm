package com.study.algorithm.site.leetCode;

public class EasySolutionWithExplanation {

	public static void main(String[] args) {
//		System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
		System.out.println(lengthOfLastWord2("   fly me   to   the moon  "));
	}

	private static int lengthOfLastWord(String s) {
		s = s.trim();

		int length = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				length++;
			} else if (length > 0) {
				break;
			}
		}

		return length;
	}

	private static int lengthOfLastWord2(String s) {
		String[] split = s.trim().split(" ");
		return split[split.length - 1].length();
	}
}
