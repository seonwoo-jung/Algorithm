package com.study.algorithm.book.doit_middle.ch08_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_18352_특정거리의도시찾기 {

	private static ArrayList<ArrayList<Integer>> graph;
    private static int[] ch;
    private static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
        answer = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}

		ch = new int[N + 1];

        solution(X, K);

        System.out.println(answer);
	}

	private static void solution(int s, int k) {
		Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[s] = 1;
        int L = 0;

		while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();

                if (L == k) {
                    answer.add(cur);
                } else {
                    for (int nx : graph.get(cur)) {
                        if (ch[nx] == 0) {
                            ch[nx] = 1;
                            Q.offer(nx);
                        }
                    }
                }
            }
            L++;
		}
	}
}
