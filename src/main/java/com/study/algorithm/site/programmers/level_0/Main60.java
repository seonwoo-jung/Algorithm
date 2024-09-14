package com.study.algorithm.site.programmers.level_0;

public class Main60 {

	public static void main(String[] args) {
		solution("205");
	}

	private static String solution(String rsp) {
		String data = "";

		for (int i = 0; i < rsp.length(); i++) {
			data += calculate(rsp.substring(i, i + 1));
		}

		return data;
	}

	private static String calculate(String param) {
		if (param.equals("2")) {
			return "0";
		} else if (param.equals("0")) {
			return "5";
		} else {
			return "2";
		}
	}
}