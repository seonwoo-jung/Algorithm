package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Arrays.sort;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = kb.nextInt();

        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = kb.nextInt();

        ArrayList<Integer> solution = solution(n, m, a, b);
        for (Integer x : solution) {
            System.out.printf("%d ", x);
        }
    }

    static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        sort(a);
        sort(b);

        while (p1 < n && p2 < m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }
}