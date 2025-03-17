package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1300_배열에서K번째수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long lt = 1, rt = K;
        long answer = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            if (cnt < K) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
