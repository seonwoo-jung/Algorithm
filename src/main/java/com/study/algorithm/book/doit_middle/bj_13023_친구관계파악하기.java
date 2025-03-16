package com.study.algorithm.book.doit_middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_13023_친구관계파악하기 {

    private static int answer = 0;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            if (flag) break;
            DFS(i, 1);
        }

        System.out.println(answer);
    }

    private static void DFS(int now, int L) {
        if (L >= 5 || flag) {
            flag = true;
            answer = 1;
        } else {
            visited[now] = true;
            for (int nx : graph.get(now)) {
                if (!visited[nx]) {
                    DFS(nx, L + 1);
                }
            }
            visited[now] = false;
        }
    }
}
