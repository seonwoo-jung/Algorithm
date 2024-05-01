package inflearn.ch06;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.in;
import static java.util.Arrays.sort;

/**
 * 중복 확인
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        String solution = solution2(n, arr);
        System.out.println("solution = " + solution);
    }

    static String solution2(int n, int[] arr) {
        String answer = "U";
        sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) return "D";
        }
        return answer;
    }

    static String solution(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        return set.size() == n ? "U" : "D";
    }
}
