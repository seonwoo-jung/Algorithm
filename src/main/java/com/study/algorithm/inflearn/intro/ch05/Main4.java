package com.study.algorithm.inflearn.intro.ch05;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Character.isDigit;
import static java.lang.System.in;

/**
 * 후위식 연산(postfix)
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(in);
		String str = kb.next();
		System.out.println("solution = " + solution(str));
	}

	private static int solution(String str) {
		Stack<Integer> stack = new Stack<>();
		for (char x : str.toCharArray()) {
			if (isDigit(x)) {
				stack.push(x - 48);
			} else {
				int rt = stack.pop();
				int lt = stack.pop();
				if (x == '+') stack.push(rt + lt);
				else if (x == '-') stack.push(lt - rt);
				else if (x == '*') stack.push(lt * rt);
				else if (x == '/') stack.push(lt / rt);
			}
		}
		return stack.get(0);
	}
}