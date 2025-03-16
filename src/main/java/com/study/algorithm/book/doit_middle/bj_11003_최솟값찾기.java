package com.study.algorithm.book.doit_middle;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class bj_11003_최솟값찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ArrayDeque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));
            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    private static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
