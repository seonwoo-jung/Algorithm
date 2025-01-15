package com.study.algorithm.site.programmers.unlevel;

import java.util.Arrays;

public class Main3_지폐접기 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{30, 15}, new int[]{26, 17}));
		System.out.println(solution(new int[]{50, 50}, new int[]{100, 241}));
	}

	private static int solution(int[] wallet, int[] bill) {
		Arrays.sort(wallet);
		Arrays.sort(bill);
		int answer = 0;

		while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
			if (bill[0] > bill[1]) {
				bill[0] /= 2;
			} else {
				bill[1] /= 2;
			}
			Arrays.sort(bill);
			answer++;
		}

		return answer;
	}
}
