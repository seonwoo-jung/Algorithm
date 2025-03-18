package com.study.algorithm.book.doit_middle.ch06_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj_1744_수를묶어서최댓값만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minusQ = new PriorityQueue<>();
        int answer = 0;
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                zeroCount++;
            } else if (num == 1) {
                oneCount++;
            } else if (num > 1) {
                plusQ.offer(num);
            } else {
                minusQ.offer(num);
            }
        }

        while (plusQ.size() > 1) {
            int a = plusQ.poll();
            int b = plusQ.poll();
            answer += a * b;
        }
        while (!plusQ.isEmpty()) {
            int a = plusQ.poll();
            answer += a;
        }

        while (minusQ.size() > 1) {
            int a = minusQ.poll();
            int b = minusQ.poll();
            answer += a * b;
        }
        while (!minusQ.isEmpty()) {
            int a = minusQ.poll();
            if (zeroCount > 0) {
                zeroCount--;
            } else {
                answer += a;
            }
        }

        answer += oneCount;

        System.out.println(answer);
    }
}
