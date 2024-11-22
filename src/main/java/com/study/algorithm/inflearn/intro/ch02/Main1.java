package com.study.algorithm.inflearn.intro.ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 큰 수 출력하기
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
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

	private static ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				answer.add(arr[i]);
			}
		}
		return answer;
	}
}