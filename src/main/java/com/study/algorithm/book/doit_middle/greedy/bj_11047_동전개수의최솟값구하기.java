package com.study.algorithm.book.doit_middle.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj_11047_동전개수의최솟값구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        Integer[] coin = new Integer[N];

        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin, Collections.reverseOrder());
        int cnt = 0;

        for (int i = 0; i < coin.length; i++) {
            if (coin[i] <= K) {
                cnt += (K / coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(cnt);
    }
}
