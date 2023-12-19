package other;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Node node = new Node(1);

        node.lt = new Node(2);
        node.rt = new Node(3);

        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);
        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);
        BFS(node);
    }

    static void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
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
