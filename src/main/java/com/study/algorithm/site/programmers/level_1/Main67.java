package com.study.algorithm.site.programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 데이터 분석
 */
public class Main67 {

	public static void main(String[] args) {
		int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		int[][] answer = solution(data, ext, val_ext, sort_by);
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.println(answer[i][j]);
			}
		}
	}

	private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		Map<String, Integer> colOrder = new HashMap<>();
		colOrder.put("code", 0);
		colOrder.put("date", 1);
		colOrder.put("maximum", 2);
		colOrder.put("remain", 3);

		int[][] filteredData = Arrays.stream(data).filter(x -> x[colOrder.get(ext)] < val_ext).toArray(int[][]::new);
		Arrays.sort(filteredData, (o1, o2) ->  o1[colOrder.get(sort_by)] - o2[colOrder.get(sort_by)]);

		return filteredData;
	}
}
