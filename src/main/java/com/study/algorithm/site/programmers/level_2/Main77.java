package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;

public class Main77 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
    }

    private static String[] solution(String[] files) {
        int[][] board = new int[5][5];
        int n = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = n++;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%-5d ", board[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        // 평면좌표처럼 출력하기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%d ", board[board.length - 1 - i][j]);
            }
            System.out.println();
        }
        return null;
    }
}