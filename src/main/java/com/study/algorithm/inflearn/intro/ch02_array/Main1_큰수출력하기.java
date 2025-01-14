package com.study.algorithm.inflearn.intro.ch02_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 큰 수 출력하기
 */
public class Main1_큰수출력하기 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(solution2(n, arr));
	}

	private static List<Integer> solution2(int n, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				answer.add(arr[i]);
			}
		}
		return answer;
	}
}