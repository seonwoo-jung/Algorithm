package com.study.algorithm.site.programmers.level_2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main47 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{5, 12, 30}, new int[]{1, 2, 0, 1}, 10));
		System.out.println(solution(new int[]{5}, new int[]{0, 0, 0, 0, 0}, 5));
	}

	public static int solution(int[] menu, int[] order, int k) {
		int answer = Integer.MIN_VALUE;

		Queue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.order, o2.order));
		A:
		for (int i = 0; i < order.length; i++) {
			int time = menu[order[i]];
			Q.offer(new Node(time, i));
			int level = 0;

			while (!Q.isEmpty()) {
				level++;

				Node cur = Q.poll();

				if (cur.remainTime > 0) {
					cur.remainTime--;

					if (cur.remainTime == 0) {

					} else {
						Q.offer(cur);
					}
				}

				answer = Math.max(answer, Q.size());

				if (level == k) {
					continue A;
				}
			}
		}
		return answer;
	}

	private static class Node {

		int remainTime;
		int order;

		public Node(int remainTime, int order) {
			this.remainTime = remainTime;
			this.order = order;
		}
	}
}