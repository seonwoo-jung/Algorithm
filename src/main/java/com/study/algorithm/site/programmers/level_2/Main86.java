package com.study.algorithm.site.programmers.level_2;

public class Main86 {

    public static void main(String[] args) {
        System.out.println((solution(16)));
        System.out.println((solution(2554)));
    }

    private static int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;
            storey = storey / 10;

            if (digit == 5) {
                if (storey % 10 >= 5) {
                    answer = answer + (10 - digit);
                    storey++;
                } else {
                    answer += digit;
                }
            } else if (digit > 5) {
                answer = answer + (10 - digit);
                storey++;
            } else {
                answer = answer + digit;
            }
        }

        return answer;
    }
}
