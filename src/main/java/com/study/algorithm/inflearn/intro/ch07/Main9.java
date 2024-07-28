package com.study.algorithm.inflearn.intro.ch07;

import static java.lang.Math.min;

/**
 * Tree 말단노드까지의 가장 짧은 경로(DFS)
 */
public class Main9 {

	Node root;

	public static void main(String[] args) {
		Main9 tree = new Main9();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(DFS(0, tree.root));

	}

	static int DFS(int L, Node root) {
		if (root.lt == null && root.rt == null) {
			return L;
		} else {
			return min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
		}
	}

	static class Node {
		int data;
		Node lt, rt;

		public Node(int val) {
			data = val;
			lt = rt = null;
		}
	}
}
