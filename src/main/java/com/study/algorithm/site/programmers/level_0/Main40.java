package com.study.algorithm.site.programmers.level_0;

public class Main40 {

	public static void main(String[] args) {
		String[] spell = {"p", "o", "s"};
		String[] dic = {"def", "dww", "dzx", "loveaw"};
		int solution = solution(spell, dic);
		System.out.println("solution = " + solution);
	}

	private static int solution(String[] spell, String[] dic) {
		boolean wordCheck = false;
		for (String word : dic) {
			int count = 0;
			for (String s : spell) {
				if (word.contains(s)) count++;
			}
			if (count == spell.length) {
				wordCheck = true;
				break;
			}
		}
		return wordCheck ? 1 : 2;
	}
}