package inflearn.ch03;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 두 배열 합치기
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        int m = kb.nextInt();

        int[] b = new int[m];

        for (int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        ArrayList<Integer> solution = solution(n, m, a, b);
        System.out.println(solution);
    }

    static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 포인터
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }

        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);
        return answer;
    }
}
