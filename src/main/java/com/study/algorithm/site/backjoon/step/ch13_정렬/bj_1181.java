package com.study.algorithm.site.backjoon.step.ch13_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class bj_1181 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> set = new TreeSet<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (String s : set) {
			System.out.println(s);
		}
	}
}