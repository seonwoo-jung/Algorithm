package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int target = 1;

		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				target++;
				while (!stack.isEmpty() && target == stack.peek()) {
					target++;
					stack.pop();
				}
			} else {
				stack.push(array[i]);
			}
		}

		for (int i = 0; i < stack.size(); i++) {
			if (target == stack.peek()) {
				target++;
				stack.pop();
			} else {
				System.out.println("Sad");
				return;
			}
		}

		System.out.println("Nice");
	}
}