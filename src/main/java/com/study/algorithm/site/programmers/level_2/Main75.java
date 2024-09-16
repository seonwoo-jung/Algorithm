package com.study.algorithm.site.programmers.level_2;

import java.util.Stack;

public class Main75 {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }

    private static int solution(int[] order) {
        int answer = 0;
        int N = 1;
        Stack<Integer> buffer = new Stack<>();

        for (int target : order) {
            while (N <= target) {
                buffer.push(N++); // 1부터 target까지 stack에 push
            }
            // buffer의 맨 위가 target과 같다면 pop하고 answer 증가
            if (!buffer.isEmpty() && buffer.peek() == target) {
                buffer.pop();
                answer++;
            } else {
                // target을 찾지 못하면 더 이상 찾을 수 없으므로 종료
                break;
            }
        }
        return answer;
    }
}