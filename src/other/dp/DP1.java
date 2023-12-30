package other.dp;

import java.util.Scanner;

import static java.lang.System.*;

public class DP1 {

    static int[] dy;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(solution(n));
    }

    static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[n];
    }
}
