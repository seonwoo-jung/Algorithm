package com.study.algorithm.site.programmers.level_2;

import java.util.HashMap;
import java.util.Map;

public class Main59 {

	public static void main(String[] args) {
		int[] solution = solution(
			new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
			new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
			new String[]{"young", "john", "tod", "emily", "mary"},
			new int[]{12, 4, 2, 5, 10}
		);
	}

	private static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, String> map = new HashMap<>();
		Map<String, Integer> answer = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			map.put(enroll[i], referral[i]);
		}

		for (int i = 0; i < seller.length; i++) {
			int income = amount[i] * 100;
			if (map.get(seller[i]).equals("-")) {
				answer.put(seller[i], answer.getOrDefault(seller[i], 0) + income);
			} else {
				String id = seller[i];
				while (!map.get(id).equals("-")) {
					int payback = (int) (income * 0.1);
					income -= payback;
					answer.put(id, answer.getOrDefault(id, 0) + income);
					id = map.get(id);
					income = payback;
				}
			}
			System.out.println("answer = " + answer);
		}
		return null;
	}
}