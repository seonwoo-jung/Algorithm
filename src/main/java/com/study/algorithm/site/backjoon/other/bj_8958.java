package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] arr = br.readLine().toCharArray();
			int answer = 0;
			int bonus = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == 'O') {
					bonus++;
					answer += bonus;
				} else {
					bonus = 0;
				}
			}
			System.out.println(answer);
		}
	}
}
