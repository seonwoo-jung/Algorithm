package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main85 {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(solution2(new int[]{1, 2, 3, 4, 5}, 7))));
        System.out.println((Arrays.toString(solution2(new int[]{1, 1, 1, 2, 3, 4, 5}, 5))));
        System.out.println((Arrays.toString(solution2(new int[]{2, 2, 2, 2, 2}, 6))));
    }

    private static int[] solution2(int[] sequence, int k) {
        int left = 0, right = 0, sum = 0;
        int[] answer = {-1, -1};
        int minLength = Integer.MAX_VALUE;

        // 슬라이딩 윈도우를 사용한 구간 탐색
        while (right < sequence.length) {
            sum += sequence[right];

            // 현재 합이 k와 같아지면 구간을 저장
            while (sum >= k) {
                if (sum == k) {
                    int length = right - left;
                    // 더 짧은 구간을 찾으면 정답 업데이트
                    if (length < minLength) {
                        minLength = length;
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left++];
            }
            right++;
        }

        return answer;
    }

    private static int[] solution(int[] sequence, int k) {
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < sequence.length; i++) {
            int sum = sequence[i];

            if (sum == k) {
                list.add(new int[]{i, i});
            }

            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] >= sequence[j]) {
                    sum += sequence[j];
                }
                if (sum == k) {
                    list.add(new int[]{j, i});
                    break;
                }
            }
        }

        int[] answer = new int[2];
        int cur = Integer.MAX_VALUE;
        for (int[] ints : list) {
            int dis = Math.abs(ints[0] - ints[1]);
            if (dis < cur) {
                cur = dis;
                answer[0] = ints[0];
                answer[1] = ints[1];
            }
        }
        return answer;
    }
}
