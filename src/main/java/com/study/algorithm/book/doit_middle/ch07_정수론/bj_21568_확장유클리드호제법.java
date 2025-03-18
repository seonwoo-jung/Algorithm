package com.study.algorithm.book.doit_middle.ch07_정수론;

import java.io.*;
import java.util.StringTokenizer;

public class bj_21568_확장유클리드호제법 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = GCD(a, b);

        if (c % gcd != 0) {
            System.out.println(-1);
        } else {
            int mok = (int) (c / gcd);
            long[] ret = Excute(a, b);
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }

    private static long[] Excute(int a, int b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a/ b;
        long[] v = Excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    private static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
