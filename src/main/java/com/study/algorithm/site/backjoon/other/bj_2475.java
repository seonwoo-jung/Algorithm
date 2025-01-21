package com.study.algorithm.site.backjoon.other;

import java.util.Scanner;

public class bj_2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		int result = 0;
		answer = sc.nextLine();
		System.out.println("answer = " + answer);
		String[] strings = answer.split(" ");
		System.out.println("strings = " + strings);
		for (String string : strings) {
			result +=  Math.pow(Integer.valueOf(string), 2);
			System.out.println("result = " + result);
		}
		System.out.println(result % 10);
	}
}
