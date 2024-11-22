package com.study.algorithm.site.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Main65 {

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
//		System.out.println(solution(100, 100, new int[]{10}));
//		System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	}

	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> Q = new LinkedList<>();
		int answer = 0;
		int idx = 0;
		int totalWeight = 0;

		while (idx < truck_weights.length || !Q.isEmpty()) {
			answer++;

			// 다리 위의 트럭 이동 처리
			int s = Q.size();
			for (int i = 0; i < s; i++) {
				Truck cur = Q.poll();
				cur.t++;
				if (cur.t == bridge_length) {
					totalWeight -= cur.w;
				} else {
					Q.offer(cur);
				}
			}

			// 새로운 트럭 다리에 올리기
			if (idx < truck_weights.length && totalWeight + truck_weights[idx] <= weight && Q.size() < bridge_length) {
				Q.offer(new Truck(truck_weights[idx], 0));
				totalWeight += truck_weights[idx];
				idx++;
			}
		}

		return answer;
	}

	private static class Truck {
		public int w;
		public int t;

		public Truck(int w, int t) {
			this.w = w;
			this.t = t;
		}
	}
}
