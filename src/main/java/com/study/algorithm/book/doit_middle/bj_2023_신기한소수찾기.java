package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2023_신기한소수찾기 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int number, int L) {
        if (L == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        } else {
            for (int i = 1; i < 10; i++) {
                if (i % 2 == 0) {
                    continue;
                }
                if (isPrime(number * 10 + i)) {
                    DFS(number * 10 + i, L + 1);
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
