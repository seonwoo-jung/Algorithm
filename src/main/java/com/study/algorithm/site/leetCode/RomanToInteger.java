package com.study.algorithm.site.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
		System.out.println(romanToInt("MMMXLV"));
	}

	private static int romanToInt(String s) {
		int sum = 0;
		Map<Character, Integer> map = new HashMap<>();
		Map<String, Integer> exCase = new HashMap<>();
		exCase.put("IV", 4);
		exCase.put("IX", 9);
		exCase.put("XL", 40);
		exCase.put("XC", 90);
		exCase.put("CD", 400);
		exCase.put("CM", 900);
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for (Entry<String, Integer> entry : exCase.entrySet()) {
			while (s.indexOf(entry.getKey()) != -1) {
				s = s.replaceFirst(entry.getKey(), "");
				sum += entry.getValue();
			}
		}
		for (char x : s.toCharArray()) {
			sum += map.get(x);
		}

		return sum;
	}
}
