package com.study.algorithm.personal.study;

import java.util.*;

public class Main10 {

	private static Map<Integer, String> memo;

	public static void main(String[] args) {
		String[] solution = solution(30, 25, 13, "0001", new int[]{0, 29, 65, 91});
		System.out.println("solution = " + Arrays.toString(solution));
	}

	private static String[] solution(int k, int a, int b, String init_password, int[] times) {
		memo = new HashMap<>();
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < times.length; i++) {
			int L = times[i] / k;
			answer.add(DFS(L, a, b, init_password));
		}
		return answer.stream().map(String::valueOf).toArray(String[]::new);
	}

	private static String DFS(int L, int a, int b, String init_password) {
		if (L == 0) {
			return init_password;
		}

		if (memo.containsKey(L)) {
			return memo.get(L);
		}

		int result = Integer.parseInt(DFS(L - 1, a, b, init_password));
		String password = String.format("%04d", (a * result + b) % 10000);

		memo.put(L, password);

		return password;
	}
}