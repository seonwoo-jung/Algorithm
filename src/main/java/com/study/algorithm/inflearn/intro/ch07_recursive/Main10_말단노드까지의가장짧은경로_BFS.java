package com.study.algorithm.inflearn.intro.ch07_recursive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree 말단노드까지의 가장 짧은 경로(BFS)
 */
public class Main10_말단노드까지의가장짧은경로_BFS {

	private Node root;

	public static void main(String[] args) {
		Main10_말단노드까지의가장짧은경로_BFS tree = new Main10_말단노드까지의가장짧은경로_BFS();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(BFS(tree.root));
	}

	private static int BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				Node cur = Q.poll();
				// 말단노드 발견
				if (cur.lt == null && cur.rt == null) return L;
				if (cur.lt != null) Q.offer(cur.lt);
				if (cur.rt != null) Q.offer(cur.rt);
			}
			L++;
		}
		return 0;
	}

	private static class Node {

		int data;
		Node lt, rt;

		public Node(int val) {
			data = val;
			lt = rt = null;
		}
	}
}
