package com.study.algorithm.inflearn.intro.ch06_sorting;

import static java.lang.System.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 좌표 정렬(잘 외워놓기)
 */
public class Main7_좌표정렬 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x, y));
		}
		// sort가 compareTo 메서드를 기준으로 정렬한다.
		Collections.sort(arr);
		for (Point o : arr) {
			System.out.println(o.x + " " + o.y);
		}
	}

	private static class Point implements Comparable<Point> {

		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// 정렬하는 기준을 설정
		@Override
		public int compareTo(Point o) {
			// 오름차순 정렬
//        if (this.x == o.x) {
//            return this.y - o.y;
//        } else {
//            return this.x - o.x;
//        }
			// 내림차순 정렬
			if (this.x == o.x) {
				return o.y - this.y;
			} else {
				return o.x - this.x;
			}
		}
	}
}
