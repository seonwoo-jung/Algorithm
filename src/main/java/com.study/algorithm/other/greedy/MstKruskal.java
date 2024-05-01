package other.greedy;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.util.Collections.sort;

public class MstKruskal {

    static int[] unf;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        ArrayList<Edge> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) unf[i] = i;

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge(a, b, c));
        }

        int answer = 0;
        sort(arr);

        for (Edge ob : arr) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);

            // 같은 간선이면 회로가 되기 떄문에 선택하면 안됨!!
            if (fv1 != fv2) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        private int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }
}