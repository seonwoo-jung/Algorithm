package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bj_12891_DNA비밀번호 {

    private static Map<Character, Integer> requiredMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int S = Integer.parseInt(s[0]);
        int P = Integer.parseInt(s[1]);
        char[] DNA = br.readLine().toCharArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        initRequiredMap(arr);

        Map<Character, Integer> containsMap = new HashMap<>();
        int lt = 0, rt = P - 1;
        for (int i = lt; i <= rt; i++) {
            containsMap.put(DNA[i], containsMap.getOrDefault(DNA[i], 0) + 1);
        }
        int answer = 0;

        boolean isValid = true;
        for (Map.Entry<Character, Integer> required : requiredMap.entrySet()) {
            if (required.getValue() > containsMap.getOrDefault(required.getKey(), 0)) {
                isValid = false;
                break;
            }
        }
        if (isValid) answer++;

        // 슬라이딩 윈도우 적용
        for (int i = P; i < S; i++) {
            // 빠지는 문자 업데이트
            char removeWord = DNA[i - P];
            containsMap.put(removeWord, containsMap.get(removeWord) - 1);

            // 추가되는 문자 업데이트
            char addWord = DNA[i];
            containsMap.put(addWord, containsMap.getOrDefault(addWord, 0) + 1);

            // 현재 윈도우가 조건을 만족하는지 확인
            isValid = true;
            for (Map.Entry<Character, Integer> required : requiredMap.entrySet()) {
                if (required.getValue() > containsMap.getOrDefault(required.getKey(), 0)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) answer++;
        }

        System.out.println(answer);
    }

    private static void initRequiredMap(int[] arr) {
        requiredMap = new HashMap<>();
        requiredMap.put('A', arr[0]);
        requiredMap.put('C', arr[1]);
        requiredMap.put('G', arr[2]);
        requiredMap.put('T', arr[3]);
    }
}
