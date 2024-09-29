package com.study.algorithm.site.leetCode;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1, 1, 2}));
		System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
	}

	private static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0; // 빈 배열 처리

		int k = 1; // 첫 번째 요소는 고유 요소로 간주하므로 시작 인덱스는 1
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) { // 중복되지 않는 요소 찾기
				nums[k] = nums[i]; // 고유 요소를 앞부분으로 이동
				k++;
			}
		}
		return k; // 고유한 요소의 개수 반환
	}
}
