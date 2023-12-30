package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Mst_4386 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        unf = new int[n + 1];
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double a = kb.nextDouble();
            double b = kb.nextDouble();
        }

        // 거리 계산
    }

    static int Find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static class Edge implements Comparable<Edge> {
        private double v1, v2, cost;

        public Edge(double v1, double v2, double cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.cost - o.cost);
        }
    }
}
