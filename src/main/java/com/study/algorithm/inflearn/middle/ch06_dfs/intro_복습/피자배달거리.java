package com.study.algorithm.inflearn.middle.ch06_dfs.intro_복습;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자배달거리 {

    private static int n, m, len, answer = Integer.MAX_VALUE;
    private static int[] combi;
    private static List<int[]> pz, hs;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) {
                    hs.add(new int[]{i, j});
                } else if (tmp == 2) {
                    pz.add(new int[]{i, j});
                }
            }
        }
        len = pz.size();
        combi = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (int[] h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h[0] - pz.get(i)[0]) + Math.abs(h[1] - pz.get(i)[1]));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
