package com.study.algorithm.site.backjoon.step.ch09_약수배수와소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_5086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            }
            if (a % b == 0) {
                System.out.println("multiple");
            } else if (b % a == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
    }
}