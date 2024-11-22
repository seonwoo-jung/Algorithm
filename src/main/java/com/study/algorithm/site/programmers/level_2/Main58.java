package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main58 {

	public static void main(String[] args) {
		int[] solution = solution(
			new String[]{"muzi", "frodo", "apeach", "neo"},
			new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
			2
		);

		int[] solution1 = solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
		System.out.println(Arrays.toString(solution));
		System.out.println("solution1 = " + Arrays.toString(solution1));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		Map<String, HashSet<String>> reportMap = new HashMap<>();
		List<String> answer = new ArrayList<>();

		for (String s : id_list) {
			reportMap.put(s, new HashSet<>());
		}

		for (String s : report) {
			String[] split = s.split(" ");
			reportMap.get(split[1]).add(split[0]);
		}
		reportMap.entrySet().stream().filter(x -> x.getValue().size() >= k).forEach(x -> x.getValue().stream().forEach(z -> answer.add(z)));
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < id_list.length; i++) {
			int idx = i;
			int count = (int) answer.stream().filter(x -> x.equals(id_list[idx])).count();
			result.add(count);
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}