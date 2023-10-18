package inflearn.ch03;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.System.in;

/**
 * 연속 부분수열
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);

        int n = kb.nextInt(); // 배열 사이즈
        int k = kb.nextInt(); // 연속된 일수

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int solution = solution(n, k, arr);
        System.out.println("solution = " + solution);
    }

    // n: 배열 사이즈, k: 연속된 일수
    static int solution(int n, int k, int[] arr) {

        return 0;
    }
}
