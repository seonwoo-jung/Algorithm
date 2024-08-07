package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 키패드 누르기
 */
public class Main66 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));;
		System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));;
		System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));;
	}

	public static String solution(int[] numbers, String hand) {
		Map<Integer, Info> map = new HashMap<>();
		int[] Lpointer = new int[]{3, 0};
		int[] Rpointer = new int[]{3, 2};
		map.put(1, new Info('L', new int[]{0, 0}));
		map.put(4, new Info('L', new int[]{1, 0}));
		map.put(7, new Info('L', new int[]{2, 0}));

		map.put(3, new Info('R', new int[]{0, 2}));
		map.put(6, new Info('R', new int[]{1, 2}));
		map.put(9, new Info('R', new int[]{2, 2}));

		map.put(2, new Info('C', new int[]{0, 1}));
		map.put(5, new Info('C', new int[]{1, 1}));
		map.put(8, new Info('C', new int[]{2, 1}));
		map.put(0, new Info('C', new int[]{3, 1}));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) {
			Info info = map.get(numbers[i]);
			int[] xy = info.xy;
			if (info.hand == 'L') {
				Lpointer[0] = xy[0];
				Lpointer[1] = xy[1];
				sb.append("L");
			} else if (info.hand == 'R') {
				Rpointer[0] = xy[0];
				Rpointer[1] = xy[1];
				sb.append("R");
			} else {
				int lx = Lpointer[0];
				int ly = Lpointer[1];
				int rx = Rpointer[0];
				int ry = Rpointer[1];
				int Ldiff = Math.abs(lx - xy[0]) + Math.abs(ly - xy[1]);
				int Rdiff = Math.abs(rx - xy[0]) + Math.abs(ry - xy[1]);

				if (Ldiff > Rdiff) {
					Rpointer[0] = xy[0];
					Rpointer[1] = xy[1];
					sb.append("R");
				} else if (Rdiff > Ldiff) {
					Lpointer[0] = xy[0];
					Lpointer[1] = xy[1];
					sb.append("L");
				} else if (Rdiff == Ldiff) {
					if (hand.equals("right")) {
						Rpointer[0] = xy[0];
						Rpointer[1] = xy[1];
						sb.append("R");
					} else {
						Lpointer[0] = xy[0];
						Lpointer[1] = xy[1];
						sb.append("L");
					}
				}
			}
		}
		return sb.toString();
	}

	static class Info {
		char hand;
		int[] xy;

		@Override
		public String toString() {
			return "Info{" +
				"hand=" + hand +
				", xy=" + Arrays.toString(xy) +
				'}';
		}

		public Info(char hand, int[] xy) {
			this.hand = hand;
			this.xy = xy;
		}
	}
}
