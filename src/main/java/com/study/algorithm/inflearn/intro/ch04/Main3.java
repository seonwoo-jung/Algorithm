package com.study.algorithm.inflearn.intro.ch04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 매출액의 종류(Hash, sliding window)
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stdIn.nextInt();
		}
		ArrayList<Integer> list = solution2(n, k, arr);
		System.out.println("list = " + list);
	}

	static int[] solution(int n, int k, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] answer = new int[n - k + 1];
		for (int i = 0; i <= n - k; i++) {
			for (int j = i; j <= n - k + i; j++) {
				map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
			}
			answer[i] = map.size();
			map.clear();
		}

		return answer;
	}

	static ArrayList<Integer> solution2(int n, int k, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> HM = new HashMap<>();
		// 0, 1, 2
		for (int i = 0; i < k - 1; i++) {
			HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
		}
		int lt = 0;
		// 3부터 6까지 반복한다.
		for (int rt = k - 1; rt < n; rt++) {
			HM.put(arr[rt], HM.getOrDefault(arr[rt], 0));
			answer.add(HM.size());
			HM.put(arr[lt], HM.get(arr[lt]) - 1);
			if (HM.get(arr[lt]) == 0) {
				HM.remove(arr[lt]);
			}
			lt++;
		}
		return answer;
	}
}