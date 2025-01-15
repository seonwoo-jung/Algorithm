package com.study.algorithm.site.programmers.unlevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main2_이중우선순위큐 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
		System.out.println(Arrays.toString(solution(
			new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1",
				"I 333"})));
	}

	private static int[] solution(String[] operations) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Comparator.reverseOrder());

		for (String sub : operations) {
			String[] split = sub.split(" ");
			int num = Integer.parseInt(split[1]);

			switch (split[0]) {
				case "I":
					reverseQueue.offer(num);
					queue.offer(num);
					break;
				case "D":
					if (!reverseQueue.isEmpty()) {
						if (num < 0) {
							reverseQueue.remove(queue.poll());
						} else {
							queue.remove(reverseQueue.poll());
						}
					}
					break;
			}
		}

		int[] answer = new int[2];

		if (!reverseQueue.isEmpty()) {
			answer[0] = reverseQueue.poll();
			answer[1] = queue.poll();
		}

		return answer;
	}
}
