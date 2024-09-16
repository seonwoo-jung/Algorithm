package com.study.algorithm.site.programmers.level_2;

public class Main72 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    private static int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            // 현재 행의 각 열 값을 이전 행의 같은 열을 제외한 최대 합으로 갱신
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }

        // 마지막 행에서 최대 값 반환
        return Math.max(
                Math.max(land[land.length - 1][0], land[land.length - 1][1]),
                Math.max(land[land.length - 1][2], land[land.length - 1][3])
        );
    }
}