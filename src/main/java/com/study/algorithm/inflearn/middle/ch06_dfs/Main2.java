package com.study.algorithm.inflearn.middle.ch06_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 줄다리기
 */
public class Main2 {
    private static int answer;
    private static int[] nums, ch;
    private static Map<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(solution(new int[][]{{1, 7}}));
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

    private static int solution(int[][] fight) {
        answer = 0;
        nums = new int[7];
        ch = new int[7];
        map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < fight.length; i++) {
            map.putIfAbsent(fight[i][0], new ArrayList<>());
            map.get(fight[i][0]).add(fight[i][1]);
            map.putIfAbsent(fight[i][1], new ArrayList<>());
            map.get(fight[i][1]).add(fight[i][0]);
        }
        DFS(0, 0);
        return answer;
    }

    private static void DFS(int L, int number) {
        if (L == nums.length) {
            answer++;
        } else {
            A: for (int i = 0; i < 7; i++) {
                if (ch[i] == 0) {
                    for (int x : map.getOrDefault(nums[i], new ArrayList<>())) {
                        if (number % 10 == x) {
                            continue A;
                        }
                    }
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums[i]);
                    ch[i] = 0;
                }
            }
        }
    }
}
