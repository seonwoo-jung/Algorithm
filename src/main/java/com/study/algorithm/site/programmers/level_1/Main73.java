package com.study.algorithm.site.programmers.level_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 프로그래머스 - 가장 많이 받은 선물
 */
public class Main73 {

	public static void main(String[] args) {
		System.out.println(solution(
			new String[]{"muzi", "ryan", "frodo", "neo"},
			new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
				"frodo muzi", "frodo ryan", "neo muzi"}));  // 2

		System.out.println(solution(
			new String[]{"joy", "brad", "alessandro", "conan", "david"},
			new String[]{"alessandro brad", "alessandro joy", "alessandro conan",
				"david alessandro", "alessandro david"}));  // 4

		System.out.println(solution(
			new String[]{"a", "b", "c"},
			new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));  // 0
	}

	static int solution(String[] friends, String[] gifts) {
		Map<String, Map<String, Integer>> sender = new HashMap<>();
		Map<String, Map<String, Integer>> receiver = new HashMap<>();

		for (String friend : friends) {
			sender.put(friend, new HashMap<>());
			receiver.put(friend, new HashMap<>());
		}

		for (String s : gifts) {
			String[] x = s.split(" ");
			Integer giftCount = sender.get(x[0]).getOrDefault(x[1], 0);
			sender.get(x[0]).put(x[1], giftCount + 1);
			receiver.get(x[1]).put(x[0], giftCount + 1);
		}

		Map<String, Integer> senderResult = sender.entrySet().stream()
			.collect(Collectors.toMap(
				Map.Entry::getKey,  // 각 최상위 Map의 key를 그대로 사용
				entry -> entry.getValue().values().stream().mapToInt(Integer::intValue).sum()  // 내부 Map의 value 합산
			));

		Map<String, Integer> receiverResult = receiver.entrySet().stream()
			.collect(Collectors.toMap(
				Entry::getKey,
				entry -> entry.getValue().values().stream().mapToInt(Integer::intValue).sum()
			));

		System.out.println("sender = " + sender);
		System.out.println("receiver = " + receiver);
		// 보낸 수
		System.out.println("sender = " + senderResult);
		// 받은 수
		System.out.println("receiver = " + receiverResult);
		return 0;
	}
}
