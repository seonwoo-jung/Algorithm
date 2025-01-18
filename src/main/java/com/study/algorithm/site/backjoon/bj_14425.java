package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_14425 {

	public static void main(String[] args) throws Exception {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}