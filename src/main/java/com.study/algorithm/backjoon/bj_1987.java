package backjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class bj_1987 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static int r, c, answer = Integer.MIN_VALUE;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        r = kb.nextInt();
        c = kb.nextInt();

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String tmp = kb.next();
            char[] x = tmp.toCharArray();
            for (int j = 0; j < x.length; j++) {
                arr[i][j] = x[j];
            }
        }

        DFS(1, 0, 0);
    }

    static void DFS(int move, int x, int y) {
        set.add(arr[x][y]);
        answer = Math.max(answer, move);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!set.contains(arr[nx][ny])) {
                    DFS(move + 1, nx, ny);
                    set.remove(arr[nx][ny]);
                }
            }
        }
    }
}
