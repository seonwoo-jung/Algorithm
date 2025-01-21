package com.study.algorithm.site.backjoon.step.ch20_심화2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bj_26069 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			String b = st.nextToken();

			if (a.equals("ChongChong") || b.equals("ChongChong")) {
				set.add(a);
				set.add(b);
			}

			if (set.contains(a) || set.contains(b)) {
				set.add(a);
				set.add(b);
			}
		}

		System.out.println(set.size());
	}
}