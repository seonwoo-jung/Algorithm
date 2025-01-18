package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bj_18870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		int[] arr2 = arr.clone();
		Arrays.sort(arr2);

		Map<Integer, Integer> map = new HashMap<>();

		int idx = 0;

		for (int i : arr2) {
			if (!map.containsKey(i)) {
				map.put(i, idx++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(String.format("%d ", map.get(i)));
		}

		System.out.println(sb.toString());
	}
}