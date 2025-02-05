package com.study.algorithm.inflearn.intro.ch10_dp;

/**
 * 최대 부분 증가수열(LIS)
 */
public class Main3_최대부분증가수열 {

	// dy[i]를 끝으로 하는 최대 증가 수열의 최대 길이
	private static int[] dy;

	public static void main(String[] args) {
		int[] arr = {5, 3, 7, 8, 6, 2, 9, 4};
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer = 0;
		dy = new int[arr.length];
		dy[0] = 1;

		// arr[i]를 끝으로 하는 최대 증가 수열의 최대 길이를 구한다
		for (int i = 1; i < arr.length; i++) {
			int max = 0;

			// i 바로 앞부터, 0까지 반복한다.
			for (int j = i - 1; j >= 0; j--) {
				// arr[i]보다 작으면서 최대 길이를 가진 j를 찾는다.
				if (arr[j] < arr[i] && dy[j] > max) {
					max = dy[j];
				}
			}
			// 내부 for문에 만족하는 것이 없으면 1
			dy[i] = max + 1;
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}
}
