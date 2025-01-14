package com.study.algorithm.inflearn.intro.ch09_greedy;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 씨름 선수
 */
public class Main1_씨름선수 {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();

		for (int i = 0; i < n; i++) {
			int height = kb.nextInt();
			int weight = kb.nextInt();
			list.add(new Person(height, weight));
		}
		System.out.println(solution(list, n));
	}


	private static int solution(ArrayList<Person> arr, int n) {
		int cnt = 0;
		sort(arr);
		int max = MIN_VALUE;
		for (Person ob : arr) {
			if (ob.weight > max) {
				max = ob.weight;
				cnt++;
			}
		}
		return cnt;
	}

	private static class Person implements Comparable<Person> {
		private int height, weight;

		public Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Person o) {
			return o.height - this.height;
		}
	}
}
