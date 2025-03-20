package com.study.algorithm.book.doit_middle.ch09_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14425_문자열찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TNode root = new TNode();

		while (N > 0) {
			String text = br.readLine();
			TNode now = root;
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (now.next[c - 'a'] == null) {
					now.next[c - 'a'] = new TNode();
				}
				now = now.next[c - 'a'];
				if (i == text.length() - 1) {
					now.isEnd = true;
				}
			}
			N--;
		}

		int count = 0;
		while (M > 0) {
			String text = br.readLine();
			TNode now = root;
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (now.next[c - 'a'] == null) {
					break;
				}
				now = now.next[c - 'a'];
				if (i == text.length() - 1 && now.isEnd) {
					count++;
				}
			}
			M--;
		}

		System.out.println(count);
	}

	private static class TNode {
		TNode[] next = new TNode[26];
		boolean isEnd;
	}
}
