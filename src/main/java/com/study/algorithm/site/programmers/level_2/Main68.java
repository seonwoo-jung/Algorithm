package com.study.algorithm.site.programmers.level_2;

import java.util.HashSet;
import java.util.Set;

// todo: 다시보기
public class Main68 {

	private static int[] ch;
	private static Set<Integer> set;

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}

	private static int solution(String numbers) {
		int answer = 0;
		set = new HashSet<>();
		String[] nums = numbers.split("");
		ch = new int[nums.length];
		DFS(0, "", nums);


		for (Integer num : set) {
			if (isPrime(num)) {
				answer++;
			}
		}
		return answer;
	}

	private static void DFS(int L, String sum, String[] numbers) {
		if (L > numbers.length) {
			return;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (ch[i] == 0) {
				ch[i] = 1;
				set.add(Integer.parseInt(sum + numbers[i]));
				DFS(L + 1, sum + numbers[i], numbers);
				ch[i] = 0;
			}
		}
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
