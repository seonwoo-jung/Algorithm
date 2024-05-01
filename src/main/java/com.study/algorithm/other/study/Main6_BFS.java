package com.study.algorithm.other.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.in;

public class Main6_BFS {

	static int[] ch;
	static int coinLen, targetNum, answer = MAX_VALUE;

	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		coinLen = kb.nextInt();

		int[] arr = new int[coinLen];
		for (int i = 0; i < coinLen; i++) {
			arr[i] = kb.nextInt();
		}

		targetNum = kb.nextInt();

		ch = new int[targetNum + 1];

		int bfs = BFS(arr);
		System.out.println("bfs = " + bfs);
	}

	static int BFS(int[] arr) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(0);
		int level = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			System.out.printf("%d : ", level);
			for (int i = 0; i < len; i++) {
				int value = Q.poll();
				for (int j = 0; j < coinLen; j++) {
					int newValue = value + arr[j];
					if (newValue == targetNum) return (level + 1);
					System.out.printf("%d ", newValue);
					Q.offer(newValue);
				}
			}
			System.out.println();
			level++;
		}
		return -1;
	}
}