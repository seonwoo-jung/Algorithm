package com.study.algorithm.inflearn.intro.ch06_sorting;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 이분검색(오름차순이든 내림차순이든 상관없이 정렬이 돼 있어야함)
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int solution = solution(n, m, arr);
        System.out.println("solution = " + solution);
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

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
