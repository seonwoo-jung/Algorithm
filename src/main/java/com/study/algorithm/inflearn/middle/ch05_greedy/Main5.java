package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.Arrays;

public class Main5 {

	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
		System.out.println(Arrays.toString(solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
	}

	private static int[] solution(String[] students) {
		int n = students.length;
		int[] answer = new int[n];

		return answer;
	}
}
