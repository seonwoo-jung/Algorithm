package com.study.algorithm.book.doit_middle.ch11_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_14501_퇴사준비하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 2]; // 최대 수입 저장

        int[] T = new int[N + 1]; // 상담 필요 일수
        int[] P = new int[N + 1]; // 상담 완료 수입
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            // 오늘날짜 + 시간 > 퇴사일보다 클 경우
            if (i + T[i] > N + 1) {
                D[i] = D[i + 1];
            } else {
				// 퇴사일 안에 끝날경우
				D[i] = Math.max(D[i + 1], P[i] + D[i + T[i]]);
            }
        }
        System.out.println(D[1]);
    }
}
