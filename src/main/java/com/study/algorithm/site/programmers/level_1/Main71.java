package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 프로그래머스 - 신고 결과 받기
 */
public class Main71 {

	public static void main(String[] args) {
		int[] solution = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
		int[] solution2 = solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);

		System.out.println(Arrays.toString(solution));
		System.out.println(Arrays.toString(solution2));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		// 신고 당한 사용자
		Map<String, Integer> reportedUser = new HashMap<>();
		Map<String, Integer> answer = new HashMap<>();
		Map<String, Set<String>> map = new HashMap<>();

		// 유저들을 map에 입력
		for (String s : id_list) {
			reportedUser.put(s, 0);
			map.put(s, new HashSet<>());
			answer.put(s, 0);
		}

		Set<String> reportUser = new HashSet<>(Arrays.asList(report));

		String[] strArrays = reportUser.stream().toArray(String[]::new);

		for (String s : strArrays) {
			String[] x = s.split(" ");
			Set<String> id = map.get(x[0]);
			id.add(x[1]);
			Integer count = reportedUser.get(x[1]);
			reportedUser.put(x[1], count + 1);
		}

		Set<String> result = reportedUser.entrySet().stream().filter(x -> x.getValue() >= k)
			.map(Entry::getKey).collect(Collectors.toSet());

		map.forEach((key, value) -> {
			long count = value.stream().filter(result::contains).count();
			answer.put(key, (int) count);
		});


		return Arrays.stream(id_list)   // id_list 배열을 스트림으로 변환
			.mapToInt(id -> answer.get(id))  // 각 id에 대해 맵에서 값을 추출하고, 기본값 0 사용
			.toArray();  // 최종적으로 int 배열로 변환
	}
}
