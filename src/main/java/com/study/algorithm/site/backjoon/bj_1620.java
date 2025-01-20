package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			map1.put(name, i);
			map2.put(i, name);
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();

			if (Character.isAlphabetic(s.charAt(0))) {
				System.out.println(map1.get(s));
			} else {
				System.out.println(map2.get(Integer.parseInt(s)));
			}
		}
	}
}