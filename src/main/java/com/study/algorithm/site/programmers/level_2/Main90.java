package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * 다시보기
 */
public class Main90 {

	private static HashMap<String, Integer> map;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
		System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
		System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
	}

	private static String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			char[] charArr = orders[i].toCharArray();
			Arrays.sort(charArr);
			orders[i] = String.valueOf(charArr);
		}

		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < orders.length; j++) {
				StringBuilder sb = new StringBuilder();
				if (course[i] <= orders[j].length()) {
					combi(orders[j], sb, 0, 0, course[i]);
				}
			}

			for (Entry<String, Integer> entry : map.entrySet()) {
				max = Math.max(max, entry.getValue());
			}

			for (Entry<String, Integer> entry : map.entrySet()) {
				if (max >= 2 && entry.getValue() == max) {
					answer.add(entry.getKey());
				}
			}
		}

		Collections.sort(answer);

		return answer.toArray(String[]::new);
	}

	private static void combi(String str, StringBuilder sb, int idx, int cnt, int n) {
		if (cnt == n) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}

		for (int i = idx; i < str.length(); i++) {
			sb.append(str.charAt(i));
			combi(str, sb, i + 1, cnt + 1, n);
			sb.delete(cnt, cnt + 1);
		}
	}
}