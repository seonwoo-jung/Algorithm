package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Main37 {

	private static List<String> list;
	private static String[] words = {"A", "E", "I", "O", "U"};

	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
	}

	private static int solution(String word) {
		int answer = 0;
		list = new ArrayList<>();

		DFS("", 0);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(word)) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	private static void DFS(String str, int len) {
		list.add(str);
		if (len == 5) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			DFS(str + words[i], len + 1);
		}
	}
}