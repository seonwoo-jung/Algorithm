package inflearn.ch07;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 *  경로탐색(DFS)
 */
public class Main12 {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
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
        out.println(answer);
    }
}
