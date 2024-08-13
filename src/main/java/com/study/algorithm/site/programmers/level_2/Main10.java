package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main10 {

	public static void main(String[] args) {
		String solution = solution("edeaaabbccd");
		System.out.println("solution = " + solution);
	}

	public static String solution(String input) {
		Map<Character, List<Integer>> charPositions = new HashMap<>();
		Set<Character> resultSet = new HashSet<>();

		// 각 알파벳의 등장 위치 기록
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			charPositions.putIfAbsent(c, new ArrayList<>());
			charPositions.get(c).add(i);
		}

		// 조건에 맞는 알파벳 찾기
		for (Map.Entry<Character, List<Integer>> entry : charPositions.entrySet()) {
			List<Integer> positions = entry.getValue();
			if (positions.size() >= 2) {
				boolean isValid = false;
				for (int j = 1; j < positions.size(); j++) {
					if (positions.get(j) > positions.get(j - 1) + 1) {
						isValid = true;
						break;
					}
				}
				if (isValid) {
					resultSet.add(entry.getKey());
				}
			}
		}

		// Set을 리스트로 변환 후 정렬
		List<Character> resultList = new ArrayList<>(resultSet);
		Collections.sort(resultList);

		// 리스트를 문자열로 변환
		StringBuilder result = new StringBuilder();
		for (Character c : resultList) {
			result.append(c);
		}

		return result.toString().isEmpty() ? "N" : result.toString();
	}
}
