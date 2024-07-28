package com.study.algorithm.personal.greedy;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;
import static java.util.Collections.sort;

/**
 * 씨름선수
 */
public class Greedy1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		int n = kb.nextInt();
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int height = kb.nextInt();
			int weight = kb.nextInt();
			list.add(new Person(height, weight));
		}
		int solution = solution(list);
		System.out.println(solution);
	}

	static int solution(ArrayList<Person> list) {
		int cnt = 0;
		sort(list);
		int max = MIN_VALUE;
		for (Person ob : list) {
			if (ob.weight > max) {
				max = ob.weight;
				cnt++;
			}
		}
		return cnt;
	}

	static class Person implements Comparable<Person> {

		private int height, weight;

		public Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Person object) {
			return object.height - this.height;
		}
	}
}
