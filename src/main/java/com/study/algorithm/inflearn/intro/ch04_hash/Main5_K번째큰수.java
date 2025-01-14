package com.study.algorithm.inflearn.intro.ch04_hash;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * K번째 큰 수
 */
public class Main5_K번째큰수 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int k = stdIn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = stdIn.nextInt();
		}
		int solution = solution(n, k, arr);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n, int k, int[] arr) {
		int answer = 0;
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // reverseOrder로 내림차순 정렬
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int l = j + 1; l < n; l++) {
					Tset.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		int cnt = 0;
//        Tset.remove(143);
//        System.out.println("size = " + Tset.size());
//        제일 앞의 원소를 가져온다.
//        System.out.println("first = " + Tset.first());
//        제일 뒤에 원소를 가져온다.
//        System.out.println("last = " + Tset.last());

		for (int x : Tset) {
			cnt++;
			if (cnt == k) return x;
		}

		return answer;
	}
}