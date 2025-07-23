package com.study.algorithm.inflearn.intro.ch02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 큰 수 출력하기
 */
public class Main1_큰수출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(solution(n, arr));
	}

	private static List<Integer> solution(int n, int[] arr) {
		List<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				answer.add(arr[i]);
			}
		}
		return answer;
	}
}