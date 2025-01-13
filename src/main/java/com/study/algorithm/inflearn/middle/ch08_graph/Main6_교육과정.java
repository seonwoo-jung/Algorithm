package com.study.algorithm.inflearn.middle.ch08_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main6_교육과정 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
		System.out.println(solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
		System.out.println(solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
	}

	private static String[] solution(String[] subjects, String[] course) {
		int n = subjects.length;
		HashMap<String, Integer> node = new HashMap<>();
		for (int i = 0; i < n; i++) {
			node.put(subjects[i], i);
		}

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int[] indegree = new int[n];

		for (String x : course) {
			int a = node.get(x.split(" ")[0]);
			int b = node.get(x.split(" ")[1]);
			graph.get(b).add(a);
			indegree[a]++;
		}

		ArrayList<Integer> order = new ArrayList<>();
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				Q.offer(i);
			}
		}

		while (!Q.isEmpty()) {
			int pre = Q.poll();
			order.add(pre);
			for (int x : graph.get(pre)) {
				indegree[x]--;
				if (indegree[x] == 0) {
					Q.offer(x);
				}
			}
		}

		String[] answer = new String[n];
		System.out.println(order);
		for (int i = 0; i < n; i++) {
			answer[i] = subjects[order.get(i)];
		}

		return answer;
	}
}