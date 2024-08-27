package com.study.algorithm.site.programmers.level_2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main30 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
		System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
	}

	private static int solution(int[] priorities, int location) {
		char chk = (char) ('A' + location);
		Queue<Point> Q = new LinkedList<>();
		PriorityQueue<Point> PQ = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.val, p1.val));

		for (int i = 0; i < priorities.length; i++) {
			Q.offer(new Point((char) ('A' + i), priorities[i]));
			PQ.offer(new Point((char) ('A' + i), priorities[i]));
		}
		int answer = 1;
		while (!Q.isEmpty()) {
			Point cur = Q.poll();
			Point max = PQ.peek();
			if (cur.val < max.val) {
				Q.offer(cur);
			} else {
				if (cur.key == chk) {
					return answer;
				} else {
					PQ.poll();
					answer++;
				}
			}
		}

		return answer;
	}

	private static class Point {

		public char key;
		public int val;

		public Point(char key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
