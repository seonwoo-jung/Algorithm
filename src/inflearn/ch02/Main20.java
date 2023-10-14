package inflearn.ch02;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 등수계산
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int[] solution = solution(n, arr);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}