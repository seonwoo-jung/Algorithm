package com.study.algorithm.book.doit_middle.ch06_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_1931_회의실배정하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> rooms = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            int s = Integer.parseInt(strings[0]);
            int e = Integer.parseInt(strings[1]);
            rooms.add(new int[]{s, e});
        }

        rooms.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int answer = 0;
        int end = 0;

        for (int[] room : rooms) {
            if (end < room[0]) {
                end = room[1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
