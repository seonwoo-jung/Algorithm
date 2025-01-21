package com.study.algorithm.site.backjoon.step.ch20_심화2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj_25192 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());
		int answer = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			if (s.equals("ENTER")) {
				set.clear();
			} else {
				if (!set.contains(s)) {
					set.add(s);
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}