package com.study.algorithm.inflearn.intro.ch09_greedy;

import java.util.ArrayList;
import java.util.Collections;
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
		Collections.sort(arr);
		int max = Integer.MIN_VALUE;
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
