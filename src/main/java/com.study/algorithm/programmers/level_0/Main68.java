package com.study.algorithm.programmers.level_0;

public class Main68 {

	public static void main(String[] args) {
		solution(1, 16);
	}

	static int solution(int num1, int num2) {
		double answer = (double) num1 / num2 * 1000;
		return (int) answer;
	}
}