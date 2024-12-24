package com.study.algorithm.inflearn.middle.ch07_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Main1_타일점프 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 2, 1, 2, 1, 1}));
		System.out.println(solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}

	private static int solution(int[] nums) {
		Queue<Integer> Q = new LinkedList<>();
		int n = nums.length;
		int[] ch = new int[n];
		Q.offer(0);
		ch[0] = 1;
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				for (int j = 1; j <= nums[x]; j++) {
					int nx = x + j;
					if (nx == n - 1) return L + 1;
					if (nx < n && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return -1;
	}
}
