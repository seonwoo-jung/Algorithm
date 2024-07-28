package com.study.algorithm.inflearn.intro.ch09;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;
import static java.util.Collections.sort;

/**
 * 결혼식
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		ArrayList<Time> list = new ArrayList<>();
		int n = kb.nextInt();
		for (int i = 0; i < n; i++) {
			int start = kb.nextInt();
			int end = kb.nextInt();
			list.add(new Time(start, 's'));
			list.add(new Time(end, 'e'));
		}

		int solution = solution(list);
		System.out.println("solution = " + solution);
	}

	static int solution(ArrayList<Time> arr) {
		int answer = MIN_VALUE;
		sort(arr);
		int cnt = 0;
		for (Time ob : arr) {
			if (ob.state == 's') {
				cnt++;
			} else {
				cnt--;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;
	}

	static class Time implements Comparable<Time> {
		private int time;
		private char state;

		public Time(int time, char state) {
			this.time = time;
			this.state = state;
		}

		@Override
		public int compareTo(Time ob) {
			if (this.time == ob.time) return this.state - ob.state;
			else return this.time - ob.time;
		}
	}
}
