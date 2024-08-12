package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main4 {

	public static void main(String[] args) {
		int solution = solution2(new int[]{1, 4, 2}, new int[]{5, 4, 4});
		System.out.println("solution = " + solution);
	}

	private static int solution(int[] A, int[] B) {
		int answer = 0;

		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		for (int a : A) {
			pq1.add(a);
		}

		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for (int b : B) {
			pq2.add(b);
		}

		System.out.println("pq1 = " + pq1);
		System.out.println("pq2 = " + pq2);

		for (int i = 0; i < A.length; i++) {
			answer += pq1.poll() * pq2.poll();
		}

		return answer;
	}

	public static int solution2(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int length = A.length;
		int answer = 0;

		for (int i = 0; i < length; i++) {
			answer += A[i] * B[length - 1 - i];
		}

		return answer;
	}
}
