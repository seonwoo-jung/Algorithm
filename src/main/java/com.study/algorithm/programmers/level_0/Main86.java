package com.study.algorithm.programmers.level_0;

import static java.util.Arrays.sort;

public class Main86 {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 3, 3, 4};
		int solution = solution(array);
		System.out.println("solution = " + solution);
	}

	static int solution(int[] array) {
		int answer = 0, max = 0;

		// 오름차순 정렬
		sort(array);

		// 최대값 설정
		max = array[array.length - 1];

		/**
		 * 각 수의 count를 위한 배열을 만들어준다.
		 * (배열 index는 0부터 시작되기 때문에 길이는 max + 1)
		 */
		int[] count = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			System.out.println(count[array[i]]++);
		}
		max = count[0];

		// 가장 큰 count값을 max로 설정한다.
		for (int i = 1; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
				answer = i;
			} else if (max == count[i]) {
				answer = -1;
			}
		}

		// 최빈값 return
		return answer;
	}
}