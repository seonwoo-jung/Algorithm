package inflearn;

import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Arrays.sort;

public class Main2 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    static int solution(int n, int m, int[] arr) {
        int answer = 0;
        sort(arr);
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
}
