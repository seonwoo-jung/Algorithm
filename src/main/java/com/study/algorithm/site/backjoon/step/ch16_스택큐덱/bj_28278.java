package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_28278 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			switch (s.charAt(0)) {
				case '1': {
					stack.push(Integer.parseInt(s.substring(2)));
					break;
				}
				case '2': {
					System.out.println(stack.isEmpty() ? -1 : stack.pop());
					break;
				}
				case '3': {
					System.out.println(stack.size());
					break;
				}
				case '4': {
					System.out.println(stack.isEmpty() ? 1 : 0);
					break;
				}
				case '5': {
					System.out.println(stack.isEmpty() ? -1 : stack.peek());
					break;
				}
			}
		}
	}
}