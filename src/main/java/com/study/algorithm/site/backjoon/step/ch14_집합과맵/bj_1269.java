package com.study.algorithm.site.backjoon.step.ch14_집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj_1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		HashSet<Integer> setA = new HashSet<>();
		HashSet<Integer> setB = new HashSet<>();

		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		for (String x : br.readLine().split(" ")) {
			setA.add(Integer.parseInt(x));
		}

		for (String x : br.readLine().split(" ")) {
			setB.add(Integer.parseInt(x));
		}

		for (int a : setA) {
			if (!setB.contains(a)) {
				answer++;
			}
		}
		for (int b : setB) {
			if (!setA.contains(b)) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}