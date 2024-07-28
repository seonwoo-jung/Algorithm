package com.study.algorithm.site.programmers.level_0;

public class Main48 {

	public static void main(String[] args) {
		String[] strlist = {"We", "are", "the", "world!"};

		// result: 1
		System.out.println(solution(strlist));
	}

	static int[] solution(String[] strlist) {

		int[] arrlength = new int[strlist.length];

		for (int i = 0; i < strlist.length; i++) {
			arrlength[i] = strlist[i].length();
		}

		return arrlength;
	}
}