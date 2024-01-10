package programmers.level_1;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class Main46 {

    static int answer = MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ba", "na", "n", "a"}, "banana"));
        System.out.println(solution(new String[]{"app","ap","p","l","e","ple","pp"}, "apple"));
        System.out.println(solution(new String[]{"ba","an","nan","ban","n"}, "banana"));
    }

    static int solution(String[] strs, String t) {
        for (int i = 0; i < strs.length; i++) {
            if (t.contains(strs[i])) {
                DFS(1, t.replaceFirst(strs[i], ""), strs);
            }
        }
        return answer == MAX_VALUE ? -1 : answer;
    }

    static void DFS(int cnt, String t, String[] strs) {
        if (t.length() == 0) {
            answer = min(answer, cnt);
        } else {
            boolean found = false;
            for (int i = 0; i < strs.length; i++) {
                if (t.contains(strs[i])) {
                    found = true;
                    DFS(cnt + 1, t.replaceFirst(strs[i], ""), strs);
                }
            }
            if (!found) {
                answer = -1;
            }
        }
    }
}