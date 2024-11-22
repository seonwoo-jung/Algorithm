package com.study.algorithm.personal.study.study0926;

import java.util.*;

/**
 * 다익스트라 알고리즘: 음의 가중치가 없는 그래프의 한 정점에서 모든 정점까지의 최단거리를 각각 구하는 알고리즘
 * 6 9
 * 1 2 12
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 */
public class Dijkstra {

    private static int N, M;
    private static List<ArrayList<Edge>> graph;
    private static int[] dis;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt(); // 정점의 개수
        M = kb.nextInt(); // 간선의 개수
        graph = new ArrayList<>(); // 가중치 방향 그래프이기 때문에 객체를 저장해야함.

        for (int i = 0; i < M; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        solution(1);

        for (int i = 2; i <= N; i++) {
            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }

    private static void solution(int v) {
        Queue<Edge> PQ = new PriorityQueue<>();
        PQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!PQ.isEmpty()) {
            Edge tmp = PQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue; // 큰 값일경우 굳이 아래 for문을 확인 할 필요가 없음.
            for (Edge nx : graph.get(now)) {
                if (dis[nx.vex] > nowCost + nx.cost) {
                    dis[nx.vex] = nowCost + nx.cost;
                    PQ.offer(new Edge(nx.vex, nowCost + nx.cost));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {

        // 정점, 비용
        public int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        // 오름차순 정렬
        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
}