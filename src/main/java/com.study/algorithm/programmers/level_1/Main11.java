package programmers.level_1;

public class Main11 {

    public static void main(String[] args) {
        long n = 12345;
        int[] solution = solution(n);
        for (int x : solution) {
            System.out.println("x = " + x);
        }
    }

    static int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt = 0;

        while (n > 0) {
            answer[cnt++] = (int) (n % 10);
            n /= 10;
        }

        return answer;
    }
}
