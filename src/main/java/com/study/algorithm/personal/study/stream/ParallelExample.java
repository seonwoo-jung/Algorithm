package com.study.algorithm.personal.study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Thread.currentThread;

public class ParallelExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "신용권", "감자바", "람다식", "박병렬");

		Stream<String> stream = list.stream();
		stream.forEach(ParallelExample::print);

		System.out.println();

		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelExample::print);
	}

	static void print(String str) {
		System.out.println(str + " : " + currentThread().getName());
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
