package other.dfs;

import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;
import static java.lang.System.in;

public class DFS5 {

    static int answer = MAX_VALUE, n, m;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        m = kb.nextInt();
        DFS(0, 0, arr);
        System.out.println(answer);
    }


    static void DFS(int L, int sum, int[] arr) {
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m) {
            answer = min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
}
