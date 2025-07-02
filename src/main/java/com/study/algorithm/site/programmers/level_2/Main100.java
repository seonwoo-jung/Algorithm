package com.study.algorithm.site.programmers.level_2;

public class Main100 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{700, 800, 1100}, new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5));
	}

	private static int solution(int[] schedules, int[][] timelogs, int startday) {
		int answer = 0;

		outer: for (int i = 0; i < schedules.length; i++) {
			// 시간을 정확히 계산하기 위해서 분단위로 변환(60진수)
			int allowed = (schedules[i] / 100) * 60 + (schedules[i] % 100) + 10;

			int day = startday;

			for (int j = 0; j < 7; j++) {
				int today = (day - 1 + j) % 7 + 1; // 1~7 유지

				// 주말은 패스
				if (today == 6 || today == 7) continue;

				int actual = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);

				if (actual > allowed) continue outer; // 지각
			}

			answer++;
		}

		return answer;
	}
}