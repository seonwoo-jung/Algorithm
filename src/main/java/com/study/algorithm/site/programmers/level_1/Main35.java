package com.study.algorithm.site.programmers.level_1;

public class Main35 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		int solution = solution(nums);
		System.out.println("solution = " + solution);

	}

	private static int solution(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int num = nums[i] + nums[j] + nums[k];
					if (isPrime(num)) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	private static boolean isPrime(int num) {
		if (num == 1) return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}


