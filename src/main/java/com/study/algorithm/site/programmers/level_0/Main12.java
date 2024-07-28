package com.study.algorithm.site.programmers.level_0;

public class Main12 {

	public static void main(String[] args) {
		System.out.println(solution(930211));
	}

	static int solution(int n) {

		int answer = 0;

		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}

		return answer;
	}
}
