package inflearn.ch06;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * LRU
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int[] solution = solution(s, n, arr);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    static int[] solution(int s, int n, int[] arr) {

        return null;
    }
}
