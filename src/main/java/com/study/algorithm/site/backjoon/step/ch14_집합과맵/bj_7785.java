package com.study.algorithm.site.backjoon.step.ch14_집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class bj_7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> set = new TreeSet<>((a, b) -> b.compareTo(a));
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			String name = s.split(" ")[0];
			String status = s.split(" ")[1];

			if (status.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		for (String s : set) {
			System.out.println(s);
		}
	}
}