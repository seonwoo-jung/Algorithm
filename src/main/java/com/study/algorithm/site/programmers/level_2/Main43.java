package com.study.algorithm.site.programmers.level_2;

import java.util.*;

/**
 * 테스트 케이스 4, 5, 6, 10 시간 초과
 */
public class Main43 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][]{{3, 5}})));
		System.out.println(Arrays.toString(solution(new int[][]{{3, 8}, {2, 2}})));
		System.out.println(Arrays.toString(solution(new int[][]{{3, 1}, {2, 3}, {3, 9}})));
		System.out.println(Arrays.toString(solution(new int[][]{{4, 26}})));
	}

	private static String[] solution(int[][] queries) {
		List<String> answer = new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();
		map.put("rr", Arrays.asList("rr", "rr", "rr", "rr"));
		map.put("RR", Arrays.asList("RR", "RR", "RR", "RR"));
		map.put("Rr", Arrays.asList("RR", "Rr", "Rr", "rr"));

		A: for (int i = 0; i < queries.length; i++) {
			Queue<String> Q = new LinkedList<>();
			Q.offer("Rr");
			int level = 1;

			while (!Q.isEmpty()) {
				if (level == queries[i][0]) {
					for (int j = 0; j < queries[i][1] - 1; j++) {
						Q.poll();
					}

					answer.add(Q.poll());
					continue A;
				}

				int len = Q.size();
				for (int k = 0; k < len; k++) {
					String s = Q.poll();
					List<String> list = map.get(s);
					for (int j = 0; j < list.size(); j++) {
						Q.offer(list.get(j));
					}
				}
				level++;
			}
		}

		return answer.stream().toArray(String[]::new);
	}
}