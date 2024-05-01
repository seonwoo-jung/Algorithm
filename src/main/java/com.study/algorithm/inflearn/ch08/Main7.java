package inflearn.ch08;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 조합의 경우수(메모이제이션)
 * 조건: 주어진 공식으로 재귀를 이용해 구현하기
 */
public class Main7 {

    // 메모이제이션
    static int[][] dy = new int[35][35];

    static int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r]; // 메모이제이션
        if (r == 0 || n == r) return 1;
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(DFS(n, r));
    }
}
