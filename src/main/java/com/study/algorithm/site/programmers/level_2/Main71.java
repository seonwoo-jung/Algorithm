package com.study.algorithm.site.programmers.level_2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main71 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{2, 3}, 7));
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> PQ = new PriorityQueue<>();

        for (int i : scoville) {
            PQ.offer(i);
        }

        while (PQ.size() > 1) {
            if (PQ.peek() >= K) {
                return answer;
            }
            int a = PQ.poll();
            int b = PQ.poll();
            int result = a + (b * 2);
            PQ.offer(result);
            answer++;
        }

        return PQ.size() == 1 && PQ.peek() >= K ? answer : -1;
    }
}