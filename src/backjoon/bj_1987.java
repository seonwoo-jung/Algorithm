package backjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;

public class bj_1987 {

    static int[] dx = {-1, 0, 1, -1};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static int r, c, m, answer = 0;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        r = kb.nextInt();
        c = kb.nextInt();
        m = r * c - 1;

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = kb.next().charAt(0);
            }
        }

        DFS(0, 0, 0);
    }

    static void DFS(int move, int x, int y) {
        if (m == move) {
            System.out.println("끝!");
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !set.contains(arr[nx][ny])) {
                    answer++;
                    DFS(move + 1, nx, ny);
                }
            }
        }
    }
}
