package com.study.algorithm.personal.greedy;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Collections.sort;

/**
 * 회의실 배정
 */
public class Greedy2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		ArrayList<Time> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			list.add(new Time(s, e));
		}
		int solution = solution(list, n);
		System.out.println(solution);
	}

	static int solution(ArrayList<Time> arr, int n) {
		int cnt = 0;
		sort(arr);
		int et = 0;
		for (Time ob : arr) {
			if (ob.s >= et) {
				cnt++;
				et = ob.e;
			}
		}

		return cnt;
	}

	static class Time implements Comparable<Time> {

		private int s, e;

		public Time(int s, int e) {
			this.s = s;
			this.e = e;
		}

		// 정렬 기준을 설정한다.
		@Override
		public int compareTo(Time o) {
			if (this.e == o.e) {
				return this.s - o.s;
			} else {
				return this.e - o.e;
			}
		}
	}
}
