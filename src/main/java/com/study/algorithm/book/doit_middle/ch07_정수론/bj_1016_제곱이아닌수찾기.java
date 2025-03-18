package com.study.algorithm.book.doit_middle.ch07_정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1016_제곱이아닌수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int[] ch = new int[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) {
                startIndex++;
            }
            for (long j = startIndex; pow * j <= max; j++) {
                ch[(int) ((j * pow) - min)] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (ch[i] == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
