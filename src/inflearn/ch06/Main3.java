package inflearn.ch06;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 삽입정렬
 */
public class Main3 {
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
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

        return arr;
    }
}
