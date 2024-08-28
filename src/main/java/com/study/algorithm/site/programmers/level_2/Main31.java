package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main31 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
//		System.out.println(solution(new int[]{5, 6, 3, 1, 5}));
	}

	private static int solution(int[] citations) {
		Arrays.sort(citations); // 인용 횟수를 오름차순으로 정렬
		int n = citations.length;
		int result = 0;

		for (int i = 0; i < n; i++) {
			int h = n - i; // h-index 후보값 계산
			// citations[i]가 현재 h-index 후보값 이상이면, h를 H-Index로 간주할 수 있음
			if (citations[i] >= h) {
				result = h; // h값이 조건을 만족하므로 result에 저장
				break; // 조건을 만족하는 순간 h-index는 최대가 되므로 종료
			}
		}

		return result;
	}
}
