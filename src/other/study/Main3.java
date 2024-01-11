package other.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.System.in;

// todo: 해결 필요!!
public class Main3 {

    static int[] ch = new int[100000000];
    static int c, n, answer = MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);

        c = kb.nextInt();
        n = kb.nextInt();
        ch = new int[n];

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

//        DFS(0, 0, arr);
         BFS(0, arr);
        System.out.println("answer = " + answer);
    }

    static void DFS(int L, int sum, int[] arr) {

        if (sum > c) return;

        if (L == n) {
            answer = max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }

    static void BFS(int L, int[] arr) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(L, arr[0]));
        ch[0] = 1;

        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.println("현재 Level: " + len);
            for (int i = 0; i < len; i++) {
                Node tmp = Q.poll();
                if (tmp.level == arr.length) {
                    if (tmp.weight > c) continue;
                    if (tmp.weight <= c) {
                        answer = max(answer, tmp.weight);
                    }
                } else {
                        Q.offer(new Node(tmp.level + 1, tmp.weight + arr[tmp.level]));
                        Q.offer(new Node(tmp.level + 1, tmp.weight));
                    System.out.println();
                }
            }
            L++;
        }
    }

    static class Node {
        private int level, weight;

        public Node(int level, int weight) {
            this.level = level;
            this.weight = weight;
        }
    }
}