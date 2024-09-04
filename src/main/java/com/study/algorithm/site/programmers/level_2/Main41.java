package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main41 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(solution("{{123}}")));
		System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}

	private static int[] solution(String s) {
		int[] answer = {};

		s = s.substring(2, s.length() - 2);
		String[] arr = s.split("\\},\\{");

		Map<String, Integer> map = new HashMap<>();

		for (String str : arr) {
			String[] numArr = str.split(",");
			for (String num : numArr) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}

		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> map.get(s2) - map.get(s1));

		answer = new int[keyList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(keyList.get(i));
		}

		return answer;
	}
}