package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_11399_ATM인출시간계산하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] S = new int[N];

        for (int i = 1; i < N; i++) {
            int tmp = A[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (A[j] > tmp) {
                    A[j + 1] = A[j];
                } else {
                    break;
                }
            }
            A[j + 1] = tmp;
        }

        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + S[i];
        }
        System.out.println(sum);
    }
}
