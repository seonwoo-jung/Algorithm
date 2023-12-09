package programmers.level_1;

import static java.lang.String.valueOf;

public class Main10 {

    public static void main(String[] args) {
        int n = 987;
        int solution = solution(n);
        System.out.println("solution = " + solution);
    }
    static int solution(int n) {
        int answer = 0;
        for (int x : valueOf(n).toCharArray()) {
            answer += (x - 48);
        }
        return answer;
    }
}
