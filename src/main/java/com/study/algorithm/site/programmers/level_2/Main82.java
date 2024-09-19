package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main82 {

    private static int[] answer;

    public static void main(String[] args) {
        System.out.println((solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"})));
    }

    private static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] charts = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                charts[i][j] = board[i].charAt(j);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (isValid(charts, i, j)) {
                    charts[i][j] = '-';
                    charts[i][j + 1] = '-';
                    charts[i + 1][j] = '-';
                    charts[i + 1][j + 1] = '-';
                }
            }
        }

        System.out.println(Arrays.deepToString(charts));
        return answer;
    }

    private static boolean isValid(char[][] charts, int i, int j) {
        return charts[i][j] == charts[i][j + 1] && charts[i + 1][j] == charts[i + 1][j + 1];
    }
}
