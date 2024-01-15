package programmers.unlevel;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

public class Puzzle {

    static int answer = MAX_VALUE;

    public static void main(String[] args) {
        String[] arr = {"ba", "an", "nan", "ban", "n"};
        String t = "banana";
        DFS(arr, t, "", 0);
        System.out.println("answer = " + answer);
    }

    static void DFS(String[] arr, String t, String match, int cnt) {
        if (t.length() < match.length()) return;

        if (t.length() == match.length()) {
            if (t.equals(match)) {
                answer = min(answer, cnt);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                DFS(arr, t, match + arr[i], cnt + 1);
            }
        }
    }
}
