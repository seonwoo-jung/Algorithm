package com.study.algorithm.book.doit_middle;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj_11286_절댓값힙구현하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return Integer.compare(o1, o2);
            } else {
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (Q.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(Q.poll() + "\n");
                }
            } else {
                Q.offer(x);
            }
        }
        bw.flush();
    }
}
