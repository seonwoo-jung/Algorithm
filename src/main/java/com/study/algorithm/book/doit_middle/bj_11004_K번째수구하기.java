package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_11004_K번째수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);

    }

    private static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(A, S, pivot - 1, K);
            } else {
                quickSort(A, pivot + 1, E, K);
            }
        }
    }

    private static int partition(int[] A, int S, int E) {
        if (S + 1 == E) {
            if (A[S] > A[E]) {
                swap(A, S, E);
                return E;
            }
        }
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];
        int i = S + 1, j = E;

        while (i <= j) {
            while (pivot < A[j] && j > 0) {
                j--;
            }
            while (pivot > A[i] && i < A.length - 1) {
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
