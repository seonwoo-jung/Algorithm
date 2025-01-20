package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class bj_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		String[] str = br.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		String[] answer = map.entrySet().stream()
			.filter((v) -> v.getValue() == 2)
			.sorted((a, b) -> a.getKey().compareTo(b.getKey()))
			.map(Entry::getKey)
			.toArray(String[]::new);

		System.out.println(answer.length);

		for (String x : answer) {
			System.out.println(x);
		}
	}
}