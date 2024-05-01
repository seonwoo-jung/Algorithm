package com.study.algorithm.programmers.level_0;

public class Main14 {

	public static void main(String[] args) {
		System.out.println(solution(29183, 1));
	}

	public static int solution(int num, int k) {

		String newNum = String.valueOf(num);

		for (int i = 0; i < newNum.length(); i++) {
			if (Character.getNumericValue(newNum.charAt(i)) == k) {
				return i + 1;
			}
		}

		return -1;
	}


}