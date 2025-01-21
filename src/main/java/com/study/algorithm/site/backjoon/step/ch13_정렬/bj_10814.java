package com.study.algorithm.site.backjoon.step.ch13_정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj_10814 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Info> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			int num = Integer.parseInt(s.split(" ")[0]);
			String name = s.split(" ")[1];
			list.add(new Info(num, name));
		}

		Collections.sort(list, (a, b) -> a.num - b.num);

		for (Info info : list) {
			System.out.printf("%d %s\n", info.num, info.name);
		}
	}

	private static class Info {
		public int num;
		public String name;

		public Info(int num, String name) {
			this.num = num;
			this.name = name;
		}
	}
}