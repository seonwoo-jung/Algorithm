package other.dfs;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.System.in;

public class DFS6 {

    static int answer = 0;
    static int c, n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }


    static void DFS(int L, int sum, int[] arr) {
        if (sum > c) return;
        // 모든 레벨을 전부 돌았을 때
        if (L == n) {
            answer = max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], arr); // 포함한다.
            DFS(L + 1, sum, arr); // 포함하지 않는다.
        }
    }
}
