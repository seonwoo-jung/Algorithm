package com.study.algorithm.site.programmers.level_1;

import java.util.*;

/**
 * 프로그래머스 - 대충 만든 자판
 */
public class Main59 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","AABB"})));
	}

	public static int[] solution(String[] keymap, String[] targets) {
		Map<Character, Integer> map = new HashMap<>();

		// 키맵을 순회하면서 각 문자의 최소 입력 횟수를 map에 저장
		for (String keys : keymap) {
			for (int j = 0; j < keys.length(); j++) {
				char x = keys.charAt(j);
				int idx = map.getOrDefault(x, Integer.MAX_VALUE);
				if (j + 1 < idx) {
					map.put(x, j + 1);
				}
			}
		}

		List<Integer> list = new ArrayList<>();

		// 각 타겟 문자열에 대해 최소 입력 횟수를 계산
		for (String s : targets) {
			int answer = 0;
			boolean isPossible = true;
			for (char x : s.toCharArray()) {
				if (map.containsKey(x)) {
					answer += map.get(x);
				} else {
					isPossible = false; // 문자가 키맵에 존재하지 않으면 불가능한 타겟으로 처리
					break;
				}
			}
			if (isPossible) {
				list.add(answer);
			} else {
				list.add(-1); // 타겟 문자열이 불가능한 경우 -1을 추가
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
