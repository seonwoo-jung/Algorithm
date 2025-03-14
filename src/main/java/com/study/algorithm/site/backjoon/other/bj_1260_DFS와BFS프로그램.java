package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1260_DFS와BFS프로그램 {

    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        // DFS로 탐색하기
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();

        // BFS로 탐색하기
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
    }

    private static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        visited[v] = true;
        Q.offer(v);

        while (!Q.isEmpty()) {
            Integer now = Q.poll();
            System.out.print(now + " ");
            for (int nx : graph.get(now)) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    Q.offer(nx);
                }
            }
        }
    }

    private static void DFS(int now) {
        System.out.print(now + " ");
        visited[now] = true;
        for (int nx : graph.get(now)) {
            if (!visited[nx]) {
                DFS(nx);
            }
        }
    }
}
