package com.study.algorithm.site.programmers.level_0;

public class Main72 {

	public static void main(String[] args) {
		solution(15000);
	}

	static int[] solution(int money) {
		return new int[]{money / 5500, money % 5500};
	}
}