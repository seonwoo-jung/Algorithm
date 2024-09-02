package com.study.algorithm.site.programmers.level_2;

public class Main32 {

	private static int[] ch;
	private static int[][] dungeon;
	private static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
	}

	private static int solution(int k, int[][] dungeons) {
		ch = new int[dungeons.length];
		dungeon = dungeons;
		DFS(k,0);
		return answer;
	}

	private static void DFS(int k, int L) {
		// 더 이상 탐색할 던전이 없을 때 최대 레벨을 갱신
		answer = Math.max(answer, L);

		for (int i = 0; i < ch.length; i++) {
			System.out.printf("%d ", ch[i]);
		}
		System.out.println();

		// 던전 탐색 시작
		for (int i = 0; i < dungeon.length; i++) {
			if (ch[i] == 0 && k >= dungeon[i][0]) {  // 던전을 탐험할 수 있을 때만
				ch[i] = 1;  // 던전 탐험 표시
				DFS(k - dungeon[i][1], L + 1);  // 체력 소모 후 다음 던전 탐험
				ch[i] = 0;  // 원상복구 (백트래킹)
			}
		}
	}
}
