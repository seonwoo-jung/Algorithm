package com.study.algorithm.inflearn.middle.ch03_datastructure;

import java.util.LinkedList;
import java.util.Queue;

// 피부과
public class Main4 {
	public static void main(String[] args){
		System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
		System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
		System.out.println(solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
	}

	private static int solution(int[] laser, String[] enter) {
		int answer = 0;
		int n = enter.length;
		int[][] inList = new int[n][2];

		for (int i = 0; i < n; i++) {
			int a = getTime(enter[i].split(" ")[0]);
			int b = Integer.parseInt(enter[i].split(" ")[1]);
			inList[i][0] = a; // 분단위 시간
			inList[i][1] = b; // 레이저 시간
		}

		Queue<Integer> Q = new LinkedList<>();
		Q.offer(inList[0][1]);
		int fT = inList[0][0]; // 고객이 도착한 시간을 fT로 두기
		int pos = 1; // inList index를 위한 변수

		for (int t = fT; t <= 1200; t++) {
			if (pos < n && t == inList[pos][0]) {
				if (Q.isEmpty() && inList[pos][0] > fT) {
					fT = inList[pos][0];
				}
				Q.offer(inList[pos][1]);
				pos++;
			}

			// 대기실에 있는 고객을 레이저실로 이동
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
