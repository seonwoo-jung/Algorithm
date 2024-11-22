package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main61 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3,
			new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot",
				"tank"})));
		System.out.println(Arrays.toString(solution(5,
			new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage",
				"ensure", "establish", "hang", "gather", "refer", "reference", "estimate",
				"executive"})));
		System.out.println(Arrays.toString(
			solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
	}

	private static int[] solution(int n, String[] words) {
		Set<String> usedWords = new HashSet<>();
		char prevWord = words[0].charAt(0);

		for (int i = 0; i < words.length; i++) {
			if (usedWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
				return new int[]{(i % n + 1), (i / n) + 1};
			}
			usedWords.add(words[i]);
			prevWord = words[i].charAt(words[i].length() - 1);
		}

		return new int[]{0, 0};
	}
}