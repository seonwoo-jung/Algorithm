package inflearn.ch09;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;

/**
 * 다익스트라 알고리즘
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] graph = new int[n + 1][m + 1];
        for (int i = 0; i < m; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            int cost = kb.nextInt();
            graph[x][y] = cost;
        }

        for (int i = 1; i < n; i++) {
            int min = MIN_VALUE;
            for (int j = 1; j < m; j++) {
                if (min > graph[i][j]) {
                    min = graph[i][j];
                }
            }
            System.out.printf("%d의 최소비용 = %d\n", i, min);
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.printf("graph[%d][%d] = %d\n", i, j, graph[i][j]);
//            }
//        }
    }
}