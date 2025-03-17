package com.study.algorithm.book.doit_middle.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        Queue<Integer> Q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(br.readLine());
            Q.offer(card);
        }

        int sum = 0;
        while (Q.size() != 1) {
            int data1 = Q.poll();
            int data2 = Q.poll();
            sum += data1 + data2;
            Q.offer(data1 + data2);
        }
        System.out.println(sum);
    }
}
