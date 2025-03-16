package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1253_좋은수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
        int answer = 0;
        for (int k = 0; k < N; k++) {
            int find = arr[k];
            int lt = 0, rt = N - 1;

            while (lt < rt) {
                if (arr[lt] + arr[rt] == find) {
                    if (lt != k && rt != k) {
                        answer++;
                        break;
                    } else if (lt == k) {
                        lt++;
                    } else if (rt == k) {
                        rt--;
                    }
                } else if (arr[lt] + arr[rt] < find) {
                    lt++;
                } else {
                    rt--;
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}
