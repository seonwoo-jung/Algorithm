package com.study.algorithm.site.programmers.level_2;

public class Main8 {

	public static void main(String[] args) {
		int solution = solution(15);
		System.out.println("solution = " + solution);
	}

	private static int solution(int n) {
		String binary = Integer.toBinaryString(n);
		int zeroCnt = 0;
		for (char x : binary.toCharArray()) {
			if (x == '1') {
				zeroCnt++;
			}
		}
		while (true) {
			n++;
			int cnt = 0;
			String binaryString = Integer.toBinaryString(n);
			for (char x : binaryString.toCharArray()) {
				if (x == '1') {
					cnt++;
				}
			}
			if (zeroCnt == cnt) {
				return n;
			}
		}
	}
}
