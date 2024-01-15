package other.study.inflearn_code;

import java.util.Scanner;

public class Combi {

    static int[] combi;
    static int n, m;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        DFS(0, 1);
    }

    static void DFS(int L, int s) {
        if (L == m) {
            for (int x : combi) {
                System.out.printf(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
