package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_1043_거짓말쟁이가되긴싫어 {

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		ArrayList<ArrayList<Integer>> party = new ArrayList<>();
		parent = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] truePerson = new int[T];

		for (int i = 0; i < T; i++) {
			truePerson[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			party.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partySize = Integer.parseInt(st.nextToken());
			for (int j = 0; j < partySize; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			Integer firstPeople = party.get(i).get(0);
			for (int j = 1; j < party.get(i).size(); j++) {
				union(firstPeople, party.get(i).get(j));
			}
		}

		for (int i = 0; i < M; i++) {
			boolean isPossible = true;
			int cur = party.get(i).get(0);
			for (int j = 0; j < truePerson.length; j++) {
				if (find(cur) == find(truePerson[j])) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) result++;
		}
		System.out.println(result);
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}
}
