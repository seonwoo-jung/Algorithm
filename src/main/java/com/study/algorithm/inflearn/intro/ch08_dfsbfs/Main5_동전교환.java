package com.study.algorithm.inflearn.intro.ch08_dfsbfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 동전교환
 */
public class Main5_동전교환 {

	private static int n, m, answer = Integer.MAX_VALUE;

	// L은 동전갯수, sum은 동전합계
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder()); // reverseOrder(내림차순) 사용시 기본형이 아닌 객체형 Integer를 사용해야한다.
		m = kb.nextInt();
		DFS(0, 0, arr);
		System.out.println(answer);
	}

	private static void DFS(int L, int sum, Integer[] arr) {
		if (sum > m) return;
		if (L >= answer) return; // 최솟값을 구하는 것이기 때문에 L이랑 같거나 큰건 볼 필요가 없다.(시간복잡도가 줄어듦)
		if (sum == m) {
			answer = Math.min(answer, L);
		} else {
			for (int i = 0; i < n; i++) {
				DFS(L + 1, sum + arr[i], arr);
			}
		}
	}
}
