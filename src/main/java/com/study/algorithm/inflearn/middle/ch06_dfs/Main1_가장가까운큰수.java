package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1_가장가까운큰수 {
    private static List<Integer> nums;
    private static int[] ch;
    private static boolean flag;
    private static int answer, target, m;

    public static void main(String[] args) {
        System.out.println(solution(123));
//        System.out.println(solution(321));
//        System.out.println(solution(20573));
//        System.out.println(solution(27711));
//        System.out.println(solution(54312));
    }

    private static int solution(int n) {
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;

        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }
        Collections.sort(nums);
        m = nums.size();
        ch = new int[m];
        DFS(0, 0);
        if (flag == false) return -1;
        return answer;
    }

    private static void DFS(int L, int number) {
        if (flag) return;
        if (L == m) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }
}
