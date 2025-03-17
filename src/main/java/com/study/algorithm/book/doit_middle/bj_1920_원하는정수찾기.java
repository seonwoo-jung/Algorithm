package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1920_원하는정수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        int[] searchArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        for (int i = 0; i < searchArr.length; i++) {
            int lt = 0, rt = arr.length - 1;
            boolean found = false; // 찾았는지 여부 확인

            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (arr[mid] < searchArr[i]) {
                    lt = mid + 1;
                } else if (arr[mid] > searchArr[i]) {
                    rt = mid - 1;
                } else if (arr[mid] == searchArr[i]) {
                    found = true; // 값을 찾음
                    break;
                }
            }
            System.out.println(found ? "1" : "0"); // 찾았으면 1, 못 찾았으면 0
        }
    }
}
