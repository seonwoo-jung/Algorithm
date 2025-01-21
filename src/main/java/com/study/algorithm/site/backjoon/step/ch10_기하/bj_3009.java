package com.study.algorithm.site.backjoon.step.ch10_기하;

import java.util.Scanner;

public class bj_3009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 3개의 좌표 (x, y)를 입력받기
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();

		// 네 번째 점의 x, y 좌표를 구함 (짝이 맞지 않는 x, y를 찾기)
		int x4 = findFourthCoordinate(x1, x2, x3);
		int y4 = findFourthCoordinate(y1, y2, y3);

		// 네 번째 점 출력
		System.out.println(x4 + " " + y4);
	}

	private static int findFourthCoordinate(int a, int b, int c) {
		if (a == b) return c; // a, b가 같으면 c가 유일한 값
		if (a == c) return b; // a, c가 같으면 b가 유일한 값
		return a; // a가 유일한 값
	}
}