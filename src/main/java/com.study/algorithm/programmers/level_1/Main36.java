package com.study.algorithm.programmers.level_1;

public class Main36 {

	public static void main(String[] args) {
		int solution = solution(45);
		System.out.println("solution = " + solution);
	}

	static int solution(int n) {
		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toString(n, 3));
		int answer = Integer.parseInt(sb.reverse().toString(), 3);

		return answer;
	}
}


