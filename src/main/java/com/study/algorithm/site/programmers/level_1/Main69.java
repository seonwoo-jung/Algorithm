package com.study.algorithm.site.programmers.level_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 프로그래머스 - 유효 기간 검사
 */
public class Main69 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
		System.out.println(Arrays.toString(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})));
	}

	private static int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		LocalDate now = LocalDate.parse(today, formatter);

		for (String s : terms) {
			String[] x = s.split(" ");
			map.put(x[0], Integer.valueOf(x[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] x = privacies[i].split(" ");
			LocalDate date = LocalDate.parse(x[0], formatter);
			LocalDate plusDate = date.plusMonths(map.get(x[1])).minusDays(1);

			if (!plusDate.isBefore(now)) {
			} else {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
