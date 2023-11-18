package inflearn.ch07;

import java.util.Scanner;

/**
 *  경로탐색(DFS)
 */
public class Main12 {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    static int DFS(int v) {

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
