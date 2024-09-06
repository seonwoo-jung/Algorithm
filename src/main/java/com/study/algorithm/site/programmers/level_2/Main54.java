package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main54 {

	private static Node root;
	private static StringBuilder sb;

	public static void main(String[] args) {
		System.out.println(solution("ABCDEF"));
	}

	private static String solution(String message) {
		sb = new StringBuilder();
		char[] nodes = message.toCharArray();

		root = new Node(nodes[0]);

		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);

		int idx = 1;

		while (idx < nodes.length) {
			Node cur = Q.poll();

			if (idx < nodes.length) {
				cur.lt = new Node(nodes[idx++]);
				Q.offer(cur.lt);
			}

			if (idx < nodes.length) {
				cur.rt = new Node(nodes[idx++]);
				Q.offer(cur.rt);
			}
		}

		DFS(root);

		return sb.toString();
	}

	private static void DFS(Node root) {
		if (root == null) {
			return;
		} else {
			DFS(root.lt);
			DFS(root.rt);
			sb.append(root.data);
		}
	}

	private static class Node {
		char data;
		Node lt, rt;

		public Node(char val) {
			data = val;
			lt = rt = null;
		}

		@Override
		public String toString() {
			return "Node{" +
				"data=" + data +
				", lt=" + lt +
				", rt=" + rt +
				'}';
		}
	}
}