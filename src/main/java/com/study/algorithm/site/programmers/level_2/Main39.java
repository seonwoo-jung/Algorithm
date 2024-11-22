package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main39 {

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
		Set<String> wordSet = new HashSet<>();
		wordSet.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			if (wordSet.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
				int playerNumber = (i % n) + 1; // 실패한 플레이어의 번호
				int round = (i / n) + 1;        // 해당 라운드
				return new int[]{playerNumber, round};
			}
			wordSet.add(words[i]); // 현재 단어를 추가
		}

		return new int[]{0, 0};
	}
}