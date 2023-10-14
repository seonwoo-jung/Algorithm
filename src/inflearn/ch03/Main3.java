package inflearn.ch03;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.System.in;
import static java.util.Arrays.sort;

/**
 * 최대매출
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);

        int n = kb.nextInt(); // 배열 사이즈
        int k = kb.nextInt(); // 연속된 일수

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        solution(n, k, arr);
    }

    // n: 배열 사이즈, k: 연속된 일수
    static int solution(int n, int k, int[] arr) {
        int answer, sum = 0;

        // 0부터 k번 째까지 합하기
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        answer = sum;

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = max(answer, sum);
        }

        return answer;
    }
}
