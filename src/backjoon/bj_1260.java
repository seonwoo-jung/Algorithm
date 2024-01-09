package backjoon;

import java.util.Scanner;

import static java.lang.System.in;

public class bj_1260 {

    static int[] ch;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int s = kb.nextInt();

        ch = new int[n + 1];

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.printf("%d ", graph[i][j]);
            }
            System.out.println();
        }

        DFS(n, m, s, graph);
    }

    static void DFS(int n, int m, int s, int[][] graph) {
        for (int i = 1; i <= n; i++) {
            if (graph[s][i] == 1 && ch[s] == 0) {
                ch[s] = 1;
                System.out.printf("%d ", s);
                DFS(n, m, i, graph);
            }
        }
    }
}
