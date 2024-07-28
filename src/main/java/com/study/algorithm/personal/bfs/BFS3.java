package com.study.algorithm.personal.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS3 {

	public static void main(String[] args) {
		Node tree = new Node(1);
		tree.lt = new Node(2);
		tree.rt = new Node(3);
		tree.lt.lt = new Node(4);
		tree.lt.rt = new Node(5);
		int bfs = BFS(tree);
		System.out.println("bfs = " + bfs);
	}

	static int BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);

		int L = 0;

		while (!Q.isEmpty()) {
			int len = Q.size();
			// for문 i가 끝나면 같은 레벨을 모두 탐색한 것
			for (int i = 0; i < len; i++) {
				Node cur = Q.poll();
				if (cur.lt == null && cur.rt == null) return L;
				if (cur.lt != null) Q.offer(cur.lt);
				if (cur.rt != null) Q.offer(cur.rt);
			}
			L++;
		}
		return L;
	}

	static class Node {
		private Node lt, rt;
		private int data;

		public Node(int data) {
			this.data = data;
			lt = rt = null;
		}
	}
}
