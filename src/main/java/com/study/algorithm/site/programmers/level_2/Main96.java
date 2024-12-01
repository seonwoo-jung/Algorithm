package com.study.algorithm.site.programmers.level_2;

public class Main96 {

    public static void main(String[] args) {
        int solution = solution(6, new int[]{7, 10});
        System.out.println(solution);
    }

    private static int solution(int n, int[] times) {
        int curTime = 0;

        while (n > 0) {
            for (int i = 0; i < times.length; i++) {
                if (curTime % times[i] == 0) {
                    n--;
                }
            }
            curTime++;
        }

        return curTime;
    }
}