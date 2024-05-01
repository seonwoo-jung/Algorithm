package inflearn.ch06;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 버블정렬
 */
public class Main2 {
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
        // turn의 횟수
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
