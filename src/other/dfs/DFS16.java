package other.dfs;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.*;
import static java.lang.Math.abs;
import static java.lang.System.in;

/**
 * Todo: 이해필요
 */
public class DFS16 {

    static int n, m, len, answer = MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        n = kb.nextInt();
        m = kb.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = kb.nextInt();
                if (tmp == 1) hs.add(new Point(i, j));
                else if (tmp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int L, int s) {
        // 조합완성
        if (L == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = MAX_VALUE;
                for (int i : combi) {
                    dis = min(dis, abs(h.x - pz.get(i).x) + abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}