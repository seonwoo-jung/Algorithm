package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1427_내림차순으로자릿수정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
