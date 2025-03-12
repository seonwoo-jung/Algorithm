package com.study.algorithm.site.backjoon.step.ch24_누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj_16139 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String S = br.readLine();
		int q = Integer.parseInt(br.readLine());

		int[][] alpha = new int[S.length() + 1][26];

		// 나머지 문자 탐색
		for (int i = 1; i <= S.length(); i++) {
			int target = S.charAt(i - 1) - 'a';

			// 알파벳 a부터 z까지 반복
			for (int j = 0; j < 26; j++) {
				int beforeValue = alpha[i - 1][j];
				alpha[i][j] = (j == target ? beforeValue + 1 : beforeValue);
			}
		}

		while (q --> 0) {
			st = new StringTokenizer(br.readLine());

			int targetAlphabet = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken()) + 1;

			// 가장 끝점의 누적합 - 찾으려는 범위의
			bw.write((alpha[end][targetAlphabet] - alpha[start][targetAlphabet]) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}