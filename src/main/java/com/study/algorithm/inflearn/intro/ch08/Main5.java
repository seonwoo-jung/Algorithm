package com.study.algorithm.inflearn.intro.ch08;

import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;
import static java.lang.System.in;
import static java.util.Arrays.sort;
import static java.util.Collections.reverseOrder;

/**
 * 동전교환
 */
public class Main5 {

	static int n, m, answer = MAX_VALUE;

	// L은 동전갯수, sum은 동전합계
	static void DFS(int L, int sum, Integer[] arr) {
		if (sum > m) return;
		if (L >= answer) return; // 최솟값을 구하는 것이기 때문에 L이랑 같거나 큰건 볼 필요가 없다.(시간복잡도가 줄어듦)
		if (sum == m) {
			answer = min(answer, L);
		} else {
			for (int i = 0; i < n; i++) {
				DFS(L + 1, sum + arr[i], arr);
			}
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		n = kb.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		sort(arr, reverseOrder()); // reverseOrder(내림차순) 사용시 기본형이 아닌 객체형 Integer를 사용해야한다.
		m = kb.nextInt();
		DFS(0, 0, arr);
		System.out.println(answer);
	}
}
