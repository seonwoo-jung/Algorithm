package com.study.algorithm.personal.study.other;

import java.util.*;

public class Main12 {

	public static void main(String[] args) {
		int solution = solution(2, 10, new int[]{7,4,5,6});
		System.out.println("solution = " + solution);
	}

	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Vehicle> Q = new LinkedList<>();
		Q.offer(new Vehicle(truck_weights[0], 0));
		int totalWeight = truck_weights[0];
		int idx = 1;
		int answer = 0;

		while (!Q.isEmpty()) {

			for (int i = 0; i < Q.size(); i++) {
				Vehicle cur = Q.poll();
				if (cur.time < 1) {
					cur.time++;
					answer++;
				} else {
					cur.time++;
					Q.offer(cur);
				}
				if (Q.size() <= bridge_length) {
					int tmpW = truck_weights[idx];
					if (weight >= totalWeight + tmpW) {
						Q.offer(new Vehicle(truck_weights[idx], 0));
					}
				}

				Q.offer(cur);
			}
		}

		return answer;
	}

	private static class Vehicle {
		int weight;
		int time;

		public Vehicle(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
	}
}