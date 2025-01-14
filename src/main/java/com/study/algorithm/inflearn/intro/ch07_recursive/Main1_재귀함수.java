package com.study.algorithm.inflearn.intro.ch07_recursive;

import static java.lang.System.in;

import java.util.Scanner;

/**
 * 재귀함수 (자기 자신을 호출한다. 반복문의 형태, if-else 구조를 사용)
 * 스택 프레임에 매개변수 정보, 지역변수 정보, 복귀주소가 생긴다.
 */
public class Main1_재귀함수 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		DFS(n);
	}

	private static void DFS(int n) {
		if (n != 0) {
			DFS(n - 1);
			System.out.print(n + " ");
		}
	}
}
