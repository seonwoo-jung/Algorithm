package com.study.algorithm.site.backjoon.step.ch20_심화2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bj_2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			array[i] = k;
		}

		Arrays.sort(array);

		int average = (int) Math.round(Arrays.stream(array).sum() / (double) n);
		int mid = array[(n - 1) / 2];
		int frequence = findFrequence(array);
		int diff = Math.abs(array[0] - array[n - 1]);

		System.out.println(average);
		System.out.println(mid);
		System.out.println(frequence);
		System.out.println(diff);
	}

	private static int findFrequence(int[] array) {
		Map<Integer, Integer> mp = new HashMap<>();

		if (array.length == 1) {
			return array[0];
		}
		for (int i = 0; i < array.length ; i++) {
			if (mp.containsKey(array[i])) {
				mp.put(array[i], mp.get(array[i]) + 1);
			} else {
				mp.put(array[i], 1);
			}
		}
		int maxValue = Collections.max(mp.values());

		ArrayList<Integer> arrayList = new ArrayList<>();

		for (Map.Entry<Integer, Integer> newMap : mp.entrySet()) {
			if (newMap.getValue() == maxValue) {
				arrayList.add(newMap.getKey());
			}
		}

		Collections.sort(arrayList);

		if (arrayList.size() > 1) {
			return arrayList.get(1);
		} else {
			return arrayList.get(0);
		}
	}
}