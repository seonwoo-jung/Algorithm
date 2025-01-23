package com.study.algorithm.site.backjoon.step.ch11_시간복잡도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_24313 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());

		if (a1*n0 + a0 <= c*n0 && c >= a1) { //참인 경우를 if문으로 만들어 작성한 것을 볼 수 있다.
			answer = 1;
		} else {
			answer = 0;
		}

		System.out.println(answer);
	}
}