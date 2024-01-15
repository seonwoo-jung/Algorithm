package inflearn.ch09;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 친구인가 (Union&Find 알고리즘)
 * 서로소: 두 집합의 공통원소가 없어야 함
 */
public class Main6 {
    static int[] unf; // 집합을 표현

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt(); // 학생수
        int m = kb.nextInt(); // 순서쌍의 개수
        unf = new int[n + 1];

        // 배열 unf 초기화
        for (int i = 1; i <= n; i++) unf[i] = i;

        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a, b); // 친구관계이므로, a와 b를 한 집합으로 만든다.
        }
        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static int Find(int v) {
        if (v == unf[v]) return v;
        // 경로압축
        else return unf[v] = Find(unf[v]);
    }
}