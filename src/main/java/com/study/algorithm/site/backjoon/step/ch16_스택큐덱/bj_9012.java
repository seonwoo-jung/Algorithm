package com.study.algorithm.site.backjoon.step.ch16_스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		A: for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			for (char x : s.toCharArray()) {
				if (x == '(') {
					stack.push(x);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						System.out.println("NO");
						continue A;
					}
				}
			}
			System.out.println(stack.isEmpty() ? "YES" : "NO");
		}
	}
}