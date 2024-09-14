package com.study.algorithm.site.programmers.level_1;

import java.util.Locale;

/**
 * 프로그래머스 - 신규 아이디 추천
 */
public class Main68 {

	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
		System.out.println(solution("."));
	}

	private static String solution(String new_id) {
		while (
			new_id.charAt(0) == '.' ||
			new_id.charAt(new_id.length() -1) == '.' ||
			new_id.contains("..") ||
			new_id.length() < 3 ||
			new_id.length() > 15 ||
			!new_id.matches("[a-z0-9-_.]+")
		) {
			new_id = new_id
				.toLowerCase(Locale.ENGLISH)
				.replaceAll("[^a-z0-9-_.]", "")
				.replaceAll("\\.{2,}", ".")      // ..을 .으로 치환
				.replaceAll("(^\\.+|\\.+$)", "")  // 처음과 끝의 . 제거
				.replaceAll("^(.{15}).*$", "$1"); // 16자 이상 제거

			while (!new_id.isEmpty() && (new_id.charAt(0) == '.' || new_id.charAt(new_id.length() - 1) == '.')) {
				new_id = new_id.replaceAll("(^\\.+|\\.+$)", "");
			}

			if (new_id.isEmpty()) {
				return "aaa";
			} else if (new_id.length() <= 2) {
				char x = new_id.charAt(new_id.length() - 1);
				while (new_id.length() <= 2) {
					new_id += x;
				}
			}

		}
		return new_id;
	}
}
