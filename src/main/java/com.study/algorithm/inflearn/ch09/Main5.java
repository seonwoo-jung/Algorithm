package inflearn.ch09;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.in;
import static java.util.Arrays.fill;

/**
 * 다익스트라 알고리즘: 음의 가중치가 없는 그래프의 한 정점에서 모든 정점까지의 최단거리를 각각 구하는 알고리즘
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */
public class Main5 {

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        n = kb.nextInt(); // 정점의 개수
        m = kb.nextInt(); // 간선의 개수
        graph = new ArrayList<ArrayList<Edge>>(); // 가중치 방향 그래프이기 때문에 객체를 저장해야함.

        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n + 1];
        fill(dis, MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        solution(1);

        for (int i = 2; i <= n; i++) {
            if (dis[i] != MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }

    static void solution(int v) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()) {
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue; // 큰 값일경우 굳이 아래 for문을 확인 할 필요가 없음.
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }

    }

    static class Edge implements Comparable<Edge> {

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