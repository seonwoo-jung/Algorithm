package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main5_IP주소 {

	private static LinkedList<String> tmp;
	private static ArrayList<String> res;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("2025505")));
		System.out.println(Arrays.toString(solution("0000")));
		System.out.println(Arrays.toString(solution("255003")));
		System.out.println(Arrays.toString(solution("155032012")));
		System.out.println(Arrays.toString(solution("02325123")));
		System.out.println(Arrays.toString(solution("121431211")));
	}

	private static String[] solution(String s) {
		tmp = new LinkedList<>();
		res = new ArrayList<>();
		DFS(0, s);
		String[] answer = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}
		return answer;
	}

	private static void DFS(int start, String s) {
		if (tmp.size() == 4 && start == s.length()) {
			String Ts = "";
			for (String x : tmp) {
				Ts += x + ".";
			}
			res.add(Ts.substring(0, Ts.length() - 1));
		} else {
			for (int i = start; i < s.length(); i++) {
				if (s.charAt(start) == '0' && i > start) return; // 0으로 시작하고 길이가 2이상인경우 종료
				String num = s.substring(start, i + 1);
				if (Integer.parseInt(num) > 255) return; // 255이상이면 종료
				tmp.add(num);
				DFS(i + 1, s);
				tmp.pollLast();
			}
		}
	}
}
