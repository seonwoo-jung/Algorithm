package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		for (String s : br.readLine().split(" ")) {
			int i = Integer.parseInt(s);
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int m = Integer.parseInt(br.readLine());

		for (String s : br.readLine().split(" ")) {
			sb.append(map.getOrDefault(Integer.parseInt(s), 0)).append(" ");
		}

		System.out.println(sb.toString());
	}
}