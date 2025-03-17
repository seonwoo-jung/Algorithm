package com.study.algorithm.book.doit_middle.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1747_소수팰린드롬수중에서최솟값찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ch = new int[1_000_000];
        for (int i = 2; i <= Math.sqrt(ch.length); i++) {
            if (ch[i] == 0) {
                for (int j = i + i; j < ch.length; j += i) {
                    ch[j] = 1;
                }
            }
        }

        for (int i = N; i < ch.length; i++) {
            if (ch[i] == 0) {
                // 팰린드롬을 구분하는 함수만 작성하면 끝
                if (isPalindrome(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean isPalindrome(int num) {
        char[] tmp = String.valueOf(num).toCharArray();
        int lt = 0, rt = tmp.length - 1;
        while (lt < rt) {
            if (tmp[lt] != tmp[rt]) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }
}
