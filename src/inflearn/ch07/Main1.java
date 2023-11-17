package inflearn.ch07;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 재귀함수
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        DFS(n);
    }

    static void DFS(int n) {

        if (n == 0) {

        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
}
