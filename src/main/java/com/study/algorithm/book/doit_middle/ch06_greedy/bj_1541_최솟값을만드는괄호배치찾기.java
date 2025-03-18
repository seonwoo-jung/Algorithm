package com.study.algorithm.book.doit_middle.ch06_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1541_최솟값을만드는괄호배치찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        String[] str = s.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) {
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);
    }

    private static int mySum(String a) {
        String[] temp = a.split("[+]");
        int sum = 0;
        for (String s : temp) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
