package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 경고 메일
 */
public class Main7_경고메일 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
		System.out.println(Arrays.toString(solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
		System.out.println(Arrays.toString(solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
		System.out.println(Arrays.toString(solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
	}

	private static String[] solution(String[] reports, int time) {
		Map<String, Integer> inTime = new HashMap<>();
		Map<String, Integer> sumTime = new TreeMap<>();

		for (String x : reports) {
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			String c = x.split(" ")[2];

			if (c.equals("in")) {
				inTime.put(a, getTime(b));
			} else {
				sumTime.put(a, sumTime.getOrDefault(a, 0) + (getTime(b) - inTime.get(a)));
			}
		}

		ArrayList<String> res = new ArrayList<>();

		for (String name : sumTime.keySet()) {
			if (sumTime.get(name) > time) {
				res.add(name);
			}
		}

		res.sort((a, b) -> a.compareTo(b));
		String[] answer = new String[res.size()];

		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}

	private static int getTime(String time) {
		String[] t = time.split(":");
		return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
	}
}
