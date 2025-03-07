package com.study.algorithm.book.codingtest_learn.ch05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 두 개 뽑아서 더하기
 */
public class Main3_두개뽑아서더하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
		System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
	}

	private static int[] solution(int[] arr) {
		Set<Integer> answer = new HashSet<>();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				answer.add(arr[i] + arr[j]);
			}
		}

		return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * TreeSet의 경우 원소 삽입시 O(log n)의 시간복잡도가 발생하기에, 배열크기가 크다면, HashSet이 더 유리하다.
	 */
	private static int[] solution2(int[] arr) {
		Set<Integer> answer = new TreeSet<>();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				answer.add(arr[i] + arr[j]);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
