package com.study.algorithm.site.programmers.level_1;

import java.util.HashMap;

/**
 * 프로그래머스 - 가장 많이 받은 선물
 */
public class Main73 {

	public static void main(String[] args) {
		System.out.println(solution(
			new String[]{"muzi", "ryan", "frodo", "neo"},
			new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
				"frodo muzi", "frodo ryan", "neo muzi"}));  // 2

		System.out.println(solution(
			new String[]{"joy", "brad", "alessandro", "conan", "david"},
			new String[]{"alessandro brad", "alessandro joy", "alessandro conan",
				"david alessandro", "alessandro david"}));  // 4

		System.out.println(solution(
			new String[]{"a", "b", "c"},
			new String[]{"a b", "b a", "c a", "a c", "a c", "c a"}));  // 0
	}

	static int solution(String[] friends, String[] gifts) {
		int answer = 0;
		int friendsLenght = friends.length;
		HashMap<String, Integer> dic = new HashMap<>();
		int[] giftDegree = new int[friendsLenght];
		int[][] giftGraph = new int[friendsLenght][friendsLenght];

		for ( int i = 0; i < friendsLenght; i++ ) {
			dic.put(friends[i], i);
		}

		for ( String gift : gifts ) {
			String[] giftName = gift.split(" ");
			giftDegree[dic.get(giftName[0])]++;
			giftDegree[dic.get(giftName[1])]--;
			giftGraph[dic.get(giftName[0])][dic.get(giftName[1])]++;
		}

		for ( int i =0; i< friendsLenght; i++) {
			int num = 0;
			for ( int j = 0; j< friendsLenght; j++) {
				if ( i == j) {
					continue;
				}

				if (giftGraph[i][j] > giftGraph[j][i] ||
					(giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])) {
					num++;
				}
			}

			if ( answer < num) {
				answer = num;
			}

		}

		return answer;
	}
}
