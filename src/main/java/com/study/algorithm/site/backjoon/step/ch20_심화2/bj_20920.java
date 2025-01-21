package com.study.algorithm.site.backjoon.step.ch20_심화2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class bj_20920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Map<String, Integer> map = new HashMap<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (s.length() < m) {
				continue;
			}
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, (a, b) -> {
			if (!a.getValue().equals(b.getValue())) {
				return b.getValue() - a.getValue(); // 빈도수 내림차순
			} else if (a.getKey().length() != b.getKey().length()) {
				return b.getKey().length() - a.getKey().length(); // 길이 내림차순
			} else {
				return a.getKey().compareTo(b.getKey()); // 사전순 오름차순
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : list) {
			sb.append(entry.getKey()).append("\n");
		}
		System.out.print(sb);
	}
}