package com.study.algorithm.programmers.level_1;

/**
 * 프로그래머스 - 기사단원의 무기
 */
public class Main52 {

	public static void main(String[] args) {
		System.out.println(solution(10, 3, 2));
	}

	public static int solution(int number, int limit, int power) {
		int answer = 0;

		// 1. 약수 구하기
		for (int i = 1; i <= number; i++) {
			int divisorCnt = getDivisor(i);

			// 2. 공격력 제한 수치 비교
			if (divisorCnt > limit) {
				// 3. 제한 수치 초과시 필요한 철의 무게를 answer에 저장
				answer += power;
			} else {
				answer += divisorCnt;
			}
		}

		return answer;
	}

	static int getDivisor(int num) {
		int cnt = 0;
		int sqrt = (int)Math.sqrt(num);

		for (int i = 1; i <= sqrt; i++) {
			if (num % i == 0) {
				cnt++; // i는 num의 약수
				if (i != num / i) {
					cnt++; // num / i도 num의 약수
				}
			}
		}
		return cnt;

	}
}
