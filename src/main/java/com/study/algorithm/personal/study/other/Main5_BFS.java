package com.study.algorithm.personal.study.other;

import java.util.*;

import static java.lang.System.in;

public class Main5_BFS {

	static int class_cnt, limit_time;
	static List<Score> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);

		class_cnt = kb.nextInt(); // 수업개수
		limit_time = kb.nextInt(); // 제한시간

		for (int i = 0; i < class_cnt; i++) {
			int s = kb.nextInt(); // 점수
			int t = kb.nextInt(); // 소요시간
			list.add(new Score(s, t));
		}

		int bfs = BFS();
		System.out.println("bfs = " + bfs);
	}

	private static int BFS() {
		Queue<Score> Q = new LinkedList<>();
		Q.offer(new Score(0, 0));

		int level = 0;

		while (!Q.isEmpty()) {
			int len = Q.size();
			System.out.printf("%d : ", level);
			for (int i = 0; i < len; i++) {
				Score cur = Q.poll();
				System.out.println(list.size());
				for (int j = 0; j < list.size(); j++) {
					int sumScore = cur.score + list.get(j).score;
					int sumTime = cur.time + list.get(j).time;
					if (sumTime == limit_time) return sumScore + 1;
					System.out.printf("score = %d ", sumScore);
					Q.offer(new Score(sumScore, sumTime));
				}
			}
			System.out.println();
			level++;
		}
		return -1;
	}

	static class Score {
		private int score, time;

		public Score(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
}