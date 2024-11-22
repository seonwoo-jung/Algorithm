package com.study.algorithm.inflearn.intro.ch05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 응급실
 */
public class Main8 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println("solution = " + solution(n, m, arr));
	}

	private static int solution(int n, int m, int[] arr) {
		int answer = 0;
		Queue<Person> Q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Q.add(new Person(i, arr[i]));
		}

		while (!Q.isEmpty()) {
			Person tmp = Q.poll();
			for (Person x : Q) {
				if (x.priority > tmp.priority) {
					Q.add(tmp);
					tmp = null;
					break;
				}
			}

			if (tmp != null) {
				if (tmp.id == m) {
					return answer;
				} else {
					answer++;
				}
			}

		}
		return answer;
	}

	static class Person {
		private int id;
		private int priority;

		public Person(int id, int priority) {
			this.id = id;
			this.priority = priority;
		}
	}
}