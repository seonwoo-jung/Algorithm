package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Main4_팰린드롬의경우수 {

	private static Deque<Character> tmp;
	private static ArrayList<String> res;
	private static HashMap<Character, Integer> sH;
	private static int len;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("aaaabb")));
		System.out.println(Arrays.toString(solution("abbcc")));
		System.out.println(Arrays.toString(solution("abbccee")));
		System.out.println(Arrays.toString(solution("abbcceee")));
		System.out.println(Arrays.toString(solution("ffeffaae")));
	}

	private static String[] solution(String s) {
		tmp = new LinkedList<>();
		res = new ArrayList<>();
		sH = new HashMap<>();
		len = s.length();
		for (char x : s.toCharArray()) {
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		int odd = 0;
		char mid = '#';

		// 홀수가 몇개인지 확인한다
		for (char key : sH.keySet()) {
			if (sH.get(key) % 2 == 1) {
				mid = key;
				odd++;
			}
		}

		// 홀수가 2개 이상일경우 빈 배열 반환, 팰린드롬을 만들 수 없음.
		if (odd > 1) return new String[]{};

		// #이 아닐경우는 홀수가 한개 있던지, 아예 없던지 둘 중 하나임.
		// if문이 참이면 홀수가 하나라는 것임
		if (mid != '#') {
			tmp.add(mid);
			sH.put(mid, sH.get(mid) - 1);
		}

		DFS();

		String[] answer = new String[res.size()];

		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}

	private static void DFS() {
		if (tmp.size() == len) {
			String Ts = "";
			for (char x : tmp) {
				Ts += x;
			}
			res.add(Ts);
		} else {
			for (char key : sH.keySet()) {
				// 빈도수가 0인경우 팰린드롬을 만들기위해 다 쓴 것
				if (sH.get(key) == 0) continue;
				tmp.addFirst(key);
				tmp.addLast(key);
				sH.put(key, sH.get(key) - 2);
				DFS();
				tmp.pollFirst();
				tmp.pollLast();
				sH.put(key, sH.get(key) + 2);
			}
		}
	}
}
