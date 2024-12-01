package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main94 {

    private static boolean[] visited;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[] solution = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        System.out.println(Arrays.toString(solution));
    }

    private static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        DFS(0, "ICN", "ICN", tickets);

        Collections.sort(result);

        String[] answer = result.get(0).split(" ");
        return answer;
    }

    private static void DFS(int idx, String start, String route, String[][] tickets) {
        // 1. 탈출 조건 (비행기 티켓을 모두 사용한 경우)
        if (idx == tickets.length) {
            result.add(route);
            return;
        }

        // 2. 백트래킹 알고리즘 사용
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                DFS(idx + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}