package com.study.algorithm.book.doit_middle.정수론;

import java.io.*;
import java.util.StringTokenizer;

public class bj_1850_최대공약수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long result = GCD(a, b);

        while (result --> 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    private static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
