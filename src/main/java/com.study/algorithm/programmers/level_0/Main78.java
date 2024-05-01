package programmers.level_0;

public class Main78 {
    public static void main(String[] args) {
        // input: 15
        // output: 3
        int solution = solution(15);
        System.out.println("solution = " + solution);
    }

    static int solution(int n) {
        int answer = 0;
        if (n % 7 == 0) {
            answer = n / 7;
        } else {
            answer = n / 7 + 1;
        }
        return answer;
    }
}