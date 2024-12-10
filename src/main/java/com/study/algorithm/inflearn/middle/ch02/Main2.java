package com.study.algorithm.inflearn.middle.ch02;

import java.util.Arrays;

/**
 * 서로 다른 빈도수 만들기
 */
public class Main2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("aaabc")));
		System.out.println(Arrays.toString(solution("aabb")));
		System.out.println(Arrays.toString(solution("abcde")));
		System.out.println(Arrays.toString(solution("abcdeabc")));
		System.out.println(Arrays.toString(solution("abbccddee")));
	}

	private static int[] solution(String s) {
		int[] answer = new int[5];
		for (char x : s.toCharArray()) {
			answer[x - 97]++;
		}

		int max = Arrays.stream(answer).max().getAsInt();
		for (int i = 0; i < answer.length; i++) {
			answer[i] = max - answer[i];
		}

		return answer;
	}
}
