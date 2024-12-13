package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.Arrays;

// 현관문 출입 순서
public class Main3 {
	public static void main(String[] args){
		System.out.println(Arrays.toString(solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
		System.out.println(Arrays.toString(solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
		System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
	}

	private static int[] solution(int[] arrival, int[] state) {
		int[] answer = {};

		return answer;
	}
}
