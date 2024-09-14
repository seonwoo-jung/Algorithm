package com.study.algorithm.personal.dfs;

public class DFS9 {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.lt = new Node(2);
		node.rt = new Node(3);

		node.lt.lt = new Node(4);
		node.lt.rt = new Node(5);
		node.rt.lt = new Node(6);
		node.rt.rt = new Node(7);

		node.lt.lt.lt = new Node(8);
		node.lt.lt.rt = new Node(9);
		node.lt.rt.lt = new Node(10);
		node.lt.rt.rt = new Node(11);
		node.rt.lt.lt = new Node(12);
		node.rt.lt.rt = new Node(13);
		node.rt.rt.lt = new Node(14);
		node.rt.rt.rt = new Node(15);

		DFS(node);
	}

	private static void DFS(Node root) {
		if (root == null) {
			return;
		} else {
			DFS(root.lt);
			System.out.printf("%d ", root.data); // 순회위치
			DFS(root.rt);
		}
	}

	static class Node {
		private int data;
		private Node lt, rt;

		public Node(int data) {
			this.data = data;
			lt = rt = null;
		}
	}
}
