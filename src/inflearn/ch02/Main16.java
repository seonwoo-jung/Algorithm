package inflearn.ch02;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 피보나치 수열
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();

        int[] result = solution(n);
        for (int a : result) {
            System.out.println("a = " + a);
        }
    }

    static int[] solution(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }
}