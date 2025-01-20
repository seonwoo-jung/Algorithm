package com.study.algorithm.site.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj_11478 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Set<String> set = new HashSet<>();

		// 모든 시작 위치와 끝 위치로 부분 문자열 생성
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				set.add(input.substring(i, j)); // 부분 문자열 추가
			}
		}
		System.out.println(set.size());
	}
}