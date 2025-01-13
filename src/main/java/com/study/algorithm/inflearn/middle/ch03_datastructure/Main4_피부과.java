package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.LinkedList;
import java.util.Queue;

// 피부과
public class Main4_피부과 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
		System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
		System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
	}

	private static int solution(int[] laser, String[] enter) {
		int answer = 0;
		int n = enter.length;
		int[][] inList = new int[n][2];

		for (int i = 0; i < n; i++) {
			int a = getTime(enter[i].split(" ")[0]); // 분단위로 변환
			int b = Integer.parseInt(enter[i].split(" ")[1]); // 레이저 인덱스
			inList[i][0] = a;
			inList[i][1] = b;
		}

		Queue<Integer> Q = new LinkedList<>(); // 대기실
		Q.offer(inList[0][1]); // 레이저 번호 입력
		int fT = inList[0][0]; // 고객이 도착한 시간
		int pos = 1; // inList index를 위한 변수

		for (int t = fT; t <= 1200; t++) {
			// 처리할 고객이 있고, 현재 시간이 고객 도착시간이랑 동일할경우
			if (pos < n && t == inList[pos][0]) {

				// 대기실, 레이저실 둘 다 비어있을 경우 (시간 간격이 클 때 t를 1씩 증가시키는게 아니라 확 건너뜀)
				if (Q.isEmpty() && inList[pos][0] > fT) {
					fT = inList[pos][0];
				}

				// 고객을 대기실에 넣는다.
				Q.offer(inList[pos][1]);
				pos++;
			}

			if (t == fT && !Q.isEmpty()) {
				int idx = Q.poll();
				fT += laser[idx];
			}

			answer = Math.max(answer, Q.size());
		}

		return answer;
	}

	private static int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		return H * 60 + M;
	}
}
