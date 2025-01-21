package com.study.algorithm.site.backjoon.step.ch14_집합과맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_10815 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Set<Integer> containsCard = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			containsCard.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		int[] requireCard = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			requireCard[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < requireCard.length; i++) {
			if (containsCard.contains(requireCard[i])) {
				sb.append(String.format("%d ", 1));
			} else {
				sb.append(String.format("%d ", 0));
			}
		}

		System.out.println(sb.toString());
	}
}