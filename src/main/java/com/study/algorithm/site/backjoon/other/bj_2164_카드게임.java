package com.study.algorithm.site.backjoon.other;

import java.io.*;
import java.util.ArrayDeque;

public class bj_2164_카드게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            Q.addLast(i);
        }
        while (Q.size() > 1) {
            Q.pollFirst();
            Q.offerLast(Q.pollFirst());
        }

        System.out.println(Q.poll());
    }
}
