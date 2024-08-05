package com.study.algorithm.personal.study;

import java.util.ArrayDeque;

public class StackAndQueue {

	public static void main(String[] args) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < 5; i++) {
			deque.push(i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(deque.pop());
		}

		for (int i = 0; i < 5; i++) {
			deque.addLast(i);
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(deque.pollFirst());
		}
	}
}
