package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1517_버블소트프로그램2 {

    private static int[] A, tmp;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tmp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(1, N);
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int m = start + (end - start) / 2;

        mergeSort(start, m);
        mergeSort(m + 1, end);

        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }

        int k = start;
        int index1 = start;
        int index2 = m + 1;

        while (index1 <= m && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                result = result + index2 - k;
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= end) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
