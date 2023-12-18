package inflearn.ch06;

import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Arrays.stream;

/**
 * 결정 알고리즘
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        int solution = solution(n, m, arr);
        System.out.println("solution = " + solution);
    }

    static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = stream(arr).max().getAsInt();
        int rt = stream(arr).sum();
        System.out.printf("%d %d\n", lt, rt);
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}
