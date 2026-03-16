package com.study.algorithm.site.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(" "));
	}

	public static int lengthOfLongestSubstring(String s) {
		int answer = 0;
		String[] strArray = s.split("");
		for (int i = 0; i < s.length(); i++) {
			List<String> buffer = new ArrayList<>();

			for (int j = i; j < s.length(); j++) {
				if (buffer.contains(strArray[j])) {
					break;
				} else {
					buffer.add(strArray[j]);
				}
			}
			answer = Math.max(answer, buffer.size());
		}

		return answer;
	}
}
