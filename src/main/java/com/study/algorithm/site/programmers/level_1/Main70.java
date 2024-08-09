package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 공원 산책
 */
public class Main70 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
	}

	static int[] solution(String[] park, String[] routes) {
		Map<String, int[]> map = new HashMap<>();
		int[] cur = {0, 0};
		int x = park.length;
		int y = park[0].length();

		for (int i = 0; i < park.length; i++) {
			if (park[i].indexOf('S') != - 1) {
				cur[0] = i;
				cur[1] = park[i].indexOf('S');
				break;
			}
		}

		map.put("N", new int[]{-1, 0});
		map.put("S", new int[]{1, 0});
		map.put("W", new int[]{0, -1});
		map.put("E", new int[]{0, 1});

		A: for (int i = 0; i < routes.length; i++) {
			String[] s = routes[i].split(" ");
			int[] dir = map.get(s[0]);
			int nx = cur[0], ny = cur[1];

			for (int j = 0; j < Integer.valueOf(s[1]); j++) {
				nx = nx + dir[0];
				ny = ny + dir[1];

				if (nx >= x || nx < 0 || ny >= y || ny < 0 || park[nx].charAt(ny) == 'X') {
					continue A;
				}
			}
			cur[0] = nx;
			cur[1] = ny;
		}

		return cur;
	}
}
