package com.study.algorithm.inflearn.intro.ch02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 보이는 학생
 */
public class Main2_보이는학생 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(solution(n, arr));
		System.out.println(solution2(n, arr));
	}

	private static int solution(int n, int[] arr) {
		int h = Integer.MIN_VALUE;
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > h) {
				h = arr[i];
				answer++;
			}
		}
		return answer;
	}

	private static int solution2(int n, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				count++;
			}
		}
		return count;
	}
}