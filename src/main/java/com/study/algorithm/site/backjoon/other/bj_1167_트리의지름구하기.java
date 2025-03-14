package com.study.algorithm.site.backjoon.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_1167_트리의지름구하기 {

    private static boolean[] visited;
    private static int[] distance;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int v = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Node(e, v));
            }
        }
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        BFS(1);
        int max = 1;

        for (int i = 2; i <= V; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    private static void BFS(int index) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(index);
        visited[index] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();
            for (Node nx : graph.get(now)) {
                if (!visited[nx.e]) {
                    visited[nx.e] = true;
                    Q.offer(nx.e);
                    distance[nx.e] = distance[now] + nx.value;
                }
            }
        }
    }

    private static class Node {
        int e, value;

        public Node(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
