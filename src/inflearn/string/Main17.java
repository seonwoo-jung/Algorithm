package inflearn.string;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 소수(에라토스테네스 체)
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();

        solution(n);
    }

    static int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
            }
            for (int j = i; j <= n; j = j + i) {
                ch[j] = 1;
            }
        }
        return answer;
    }
}