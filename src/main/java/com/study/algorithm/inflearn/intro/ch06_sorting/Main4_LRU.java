package com.study.algorithm.inflearn.intro.ch06_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * LRU
 */
public class Main4_LRU {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(Arrays.toString(solution(s, n, arr)));
	}

	private static int[] solution(int s, int n, int[] arr) {
		int[] cache = new int[s];
		for (int x : arr) {
			int pos = -1;

			// 캐시 히트 여부를 확인
			for (int i = 0; i < s; i++) {
				if (x == cache[i]) {
					pos = i;
				}
			}

			// 캐시 미스일경우
			if (pos == -1) {
				System.out.println("cache miss: " + x);
				// 한칸씩 다 당긴다.
				for (int i = s - 1; i >= 1; i--) {
					cache[i] = cache[i - 1];
				}
			// 캐시 히트일경우
			} else {
				System.out.println("cache hit: " +  x);
				for (int i = pos; i >= 1; i--) {
					cache[i] = cache[i - 1];
				}
			}

			cache[0] = x;
			System.out.println(Arrays.toString(cache));
			System.out.println();
		}

		return cache;
	}
}
