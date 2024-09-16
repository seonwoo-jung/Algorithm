package com.study.algorithm.site.programmers.level_2;

import java.util.Stack;

public class Main73 {

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        A:
        for (String skillTree : skill_trees) {
            Stack<Character> stack = new Stack<>();
            for (int j = skill.length() - 1; j >= 0; j--) {
                stack.push(skill.charAt(j));
            }
            for (char x : skillTree.toCharArray()) {
                if (stack.contains(x)) {
                    if (x != stack.pop()) {
                        continue A;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}