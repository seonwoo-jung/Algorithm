package com.study.algorithm.book.codingtest_learn.ch08_해시;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class Main23_신고결과받기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		Map<String, HashSet<String>> reportedUser = new HashMap<>();

		Map<String, Integer> count = new HashMap<>();

		for (String r : report) {
			String[] s = r.split(" ");
			String userId = s[0];
			String reportedId = s[1];

			if (!reportedUser.containsKey(reportedId)) {
				reportedUser.put(reportedId, new HashSet<>());
			}
			reportedUser.get(reportedId).add(userId);
		}

		for (Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
			if (entry.getValue().size() >= k) {
				for (String uid : entry.getValue()) {
					count.put(uid, count.getOrDefault(uid, 0) + 1);
				}
			}
		}

		int[] answer = new int[id_list.length];

		for (int i = 0; i < id_list.length; i++) {
			answer[i] = count.getOrDefault(id_list[i], 0);
		}

		return answer;
	}
}
