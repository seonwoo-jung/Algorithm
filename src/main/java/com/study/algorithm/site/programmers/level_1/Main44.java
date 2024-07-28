package com.study.algorithm.site.programmers.level_1;

public class Main44 {

	static int[] ch;
	static int answer = 0;

	public static void main(String[] args) {
		int[] number = {-2, 3, 0, 2, -5};
		ch = new int[number.length];
		DFS(0, 0, number);
		System.out.println("answer = " + answer);
	}

	static int solution(int[] number) {
		int answer = 0;
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) {
				for (int k = j + 1; k < number.length; k++) {
					int sum = number[i] + number[j] + number[k];
					if (sum == 0) answer++;
				}
			}
		}
		return answer;
	}

	static void DFS(int L, int s, int[] number) {
		if (L == 3) {
			int sum = 0;
			for (int i = 0; i < number.length; i++) {
				if (ch[i] == 1) {
					sum += number[i];
				}
			}
			if (sum == 0) answer++;
		} else {
			for (int i = s; i < number.length; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					DFS(L + 1, s + i, number);
					ch[i] = 0;
				}
			}
		}
	}
}