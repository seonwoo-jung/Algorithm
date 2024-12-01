package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main95 {

    public static void main(String[] args) {
        int solution = solution(new int[][]{{0, 3}, {1, 9}, {3, 5}});
        System.out.println(solution);
    }

    private static int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int len = jobs.length;

        Queue<int[]> PQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (!PQ.isEmpty() || idx < len) {
            while (idx < len && jobs[idx][0] <= time) {
                PQ.offer(jobs[idx++]);
            }
            if (PQ.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] job = PQ.poll();
                time += job[1];
                answer += time - job[0];
            }
        }

        return answer / len;
    }
}