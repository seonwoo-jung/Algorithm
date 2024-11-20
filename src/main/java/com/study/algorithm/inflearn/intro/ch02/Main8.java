package com.study.algorithm.inflearn.intro.ch02;

import static java.lang.System.in;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 등수 구하기
 */
public class Main8 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		int[] solution = solution2(n, arr);
		for (int i : solution) {
			System.out.println("i = " + i);
		}
	}

	private static int[] solution2(int n, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= arr.length; i++) {
			map.put(i, arr[i - 1]);
		}

		int[] array = map
			.entrySet()
			.stream()
			.sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
			.mapToInt(Entry::getKey)
			.toArray();

		return array;
	}

	private static int[] solution(int n, int[] arr) {
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n; j++) {
				if (arr[j] > arr[i]) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}
}