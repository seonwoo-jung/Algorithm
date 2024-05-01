package com.study.algorithm.inflearn.ch06;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Arrays.sort;

/**
 * 장난꾸러기
 */
public class Main6 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}

		System.out.println(solution2(n, arr));
	}

	static int[] solution(int n, int[] arr) {
		int[] tmp = arr.clone();
		int[] answer = new int[2];
		int idx = 0;
		sort(tmp);
		for (int i = 0; i < n; i++) {
			if (arr[i] != tmp[i]) {
				answer[idx++] = i + 1;
			}
		}
		return answer;
	}

	static ArrayList<Integer> solution2(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int[] tmp = arr.clone();
		sort(tmp);
		for (int i = 0; i < n; i++) {
			if (arr[i] != tmp[i]) {
				answer.add(i + 1);
			}
		}
		return answer;
	}
}
