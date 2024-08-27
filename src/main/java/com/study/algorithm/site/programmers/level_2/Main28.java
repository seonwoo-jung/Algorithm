package com.study.algorithm.site.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Main28 {

	public static void main(String[] args) {
		int solution = solution(3,
			new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul",
				"NewYork", "LA"});
		System.out.println("solution = " + solution);

		int solution1 = solution(2,
			new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
		System.out.println("solution1 = " + solution1);
	}

	private static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> Q = new LinkedList<>();
		for (int i = 0; i < cities.length; i++) {
			if (Q.contains(cities[i].toUpperCase())) {
				Q.remove(cities[i].toUpperCase());
				Q.offer(cities[i].toUpperCase());
				answer += 1;
			} else {
				Q.offer(cities[i].toUpperCase());
				answer += 5;
			}
			while (Q.size() > cacheSize) {
				Q.poll();
			}
		}
		return answer;
	}
}
