package com.study.algorithm.programmers.level_1;

import static java.lang.String.valueOf;

public class Main3 {
	public static void main(String[] args) {
		solution(
				new String[]{
						"SOO",
						"OXX",
						"OOO"},
				new String[]{
						"E 2",
						"S 2",
						"W 1"}
		);
	}

	static int[] solution(String[] park, String[] routes) {
		int[] answer = {};
		String[][] result = new String[park.length][park[0].length()];
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				char x = park[i].charAt(j);
				result[i][j] = valueOf(x);
			}
		}
		for (String[] strings : result) {
			for (String string : strings) {
				System.out.println("string = " + string);
			}
		}
		return answer;
	}
}
