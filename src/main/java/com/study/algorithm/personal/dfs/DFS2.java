package com.study.algorithm.personal.dfs;

import static java.lang.Math.min;

public class DFS2 {

	static int n;
	static int[] ch;

	public static void main(String[] args) {
		Node node = new Node(1);
		node.lt = new Node(2);
		node.rt = new Node(3);

		node.lt.lt = new Node(4);
		node.lt.rt = new Node(5);
		int dfs = DFS(0, node);
		System.out.println("dfs = " + dfs);
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

		public Node(int data) {
			this.data = data;
			lt = rt = null;
		}
	}
}
