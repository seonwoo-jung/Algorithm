package com.study.algorithm.site.programmers.level_2;

public class Main83 {

    private static int[] arr;
    private static int[] pm;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        System.out.println((solution("1924", 2)));
//        System.out.println((solution("1231234", 3)));
//        System.out.println((solution("4177252841", 4)));
        System.out.println((solution2("1924", 2)));
        System.out.println((solution2("1231234", 3)));
        System.out.println((solution2("4177252841", 4)));
    }

    private static String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder();

        char[] array = number.toCharArray();

        int len = array.length - k;

        // 문자 비교를 시작하는 인덱스를 나타내는 start 변수
        int start = 0;

        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                // 가장 큰수를 골라서 그 다음 인덱스를 시작 인덱스로 설정하기
                if (array[j] > max) {
                    max = array[j];
                    start = j + 1;
                }
            }
            // 가장 큰 문자를 String에 넣어주기
            sb.append(max);
        }

        // k개의 수를 제거할 때 얻을 수 있는 가장 큰 숫자를 구하려 한다
        return sb.toString();
    }

    private static String solution(String number, int k) {
        pm = new int[number.length() - k];
        arr = number.chars().map(Character::getNumericValue).toArray();
        DFS(0, 0, number.length() - k);

        return String.valueOf(answer);
    }

    private static void DFS(int L, int s, int k) {
        if (L == k) {
            StringBuilder sb = new StringBuilder();
            for (int x : pm) {
                sb.append(x);
            }
            answer = Math.max(answer, Integer.parseInt(sb.toString()));
        } else {
            for (int i = s; i < arr.length; i++) {
                pm[L] = arr[i];
                DFS(L + 1, i + 1, k);
            }
        }
    }
}
