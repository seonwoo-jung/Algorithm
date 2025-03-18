package com.study.algorithm.book.doit_middle.ch07_정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1929_소수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] ch = new int[N + 1];

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (ch[i] == 0) {
                for (int j = i + i; j <= N; j += i) {
                    ch[j] = 1;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (ch[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
