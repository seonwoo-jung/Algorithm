package inflearn.ch10;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 최대 부분 증가수열
 */
public class Main3 {

    static int[] dy;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        dy = new int[n];

        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();

        System.out.println(solution(n));
    }

    static int solution(int n) {

        return 0;
    }
}
