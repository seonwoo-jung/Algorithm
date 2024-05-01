package com.study.algorithm.other.study.stream;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class LambdaExpressionsExample {
	public static void main(String[] args) {
		List<Student> list = asList(
				new Student("홍길동", 90),
				new Student("신용권", 92)
		);

		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + " - " + score);
		});
	}

	static class Student {
		private String name;
		private int score;

		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public String getName() {
			return name;
		}

		public int getScore() {
			return score;
		}
	}
}
