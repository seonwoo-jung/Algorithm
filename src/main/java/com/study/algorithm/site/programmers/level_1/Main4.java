package com.study.algorithm.site.programmers.level_1;

public class Main4 {

	static int[] combi = new int[3];

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		DFS(0, 1, nums);
	}

	static void DFS(int L, int s, int[] nums) {
		int sum = 0;
		if (L == 3) {
			for (int x : combi) {
				sum += x;
			}
			System.out.println(sum);
		} else {
			for (int i = s; i <= 4; i++) {
				combi[L] = i;
				DFS(L + 1, i + 1, nums);
			}
		}
	}
}
