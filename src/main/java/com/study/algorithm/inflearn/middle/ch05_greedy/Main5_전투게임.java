package com.study.algorithm.inflearn.middle.ch05_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 전투게임
 */
public class Main5_전투게임 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
		System.out.println(Arrays.toString(solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
	}

	private static int[] solution(String[] students) {
		int n = students.length;
		int[] answer = new int[n];
		ArrayList<Info> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Character a = students[i].split(" ")[0].charAt(0);
			int b = Integer.parseInt(students[i].split(" ")[1]);
			list.add(new Info(i, a, b));
		}

		Collections.sort(list); // 공격력을 기준으로 오름차순 정렬한다.
		HashMap<Character, Integer> Tp = new HashMap<>();

		int j = 0;
		int total = 0; // i번 전까지 학생의 총 공격력

		// i번 학생의 점수를 구하는 것
		for (int i = 1; i < n; i++) {
			for (; j < n; j++) {
				// i번 학생이 잡을 수 있는 j번 학생이 없으면 break
				if (list.get(j).power < list.get(i).power) {
					total += list.get(j).power;
					char x = list.get(j).team;
					Tp.put(x, Tp.getOrDefault(x, 0) + list.get(j).power); // 같은 팀의 총 공격력을 더한다
				} else {
					break;
				}
			}

			// 같은 팀의 공격력은 제외한다
			answer[list.get(i).idx] = total - Tp.getOrDefault(list.get(i).team, 0);
		}

		return answer;
	}

	private static class Info implements Comparable<Info> {

		public int idx;
		public Character team;
		public int power;

		public Info(int idx, Character team, int power) {
			this.idx = idx;
			this.team = team;
			this.power = power;
		}

		@Override
		public int compareTo(Info ob) {
			return this.power - ob.power;
		}
	}
}
