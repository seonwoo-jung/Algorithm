package programmers.level_0;

public class Main36 {

    public static void main(String[] args) {
        int result = solution(7, 20);
        System.out.println("result = " + result);
    }

    static int solution(int a, int b) {
        double result = a % b;
        if (result == 0.0) {
            return 1;
        } else {
            return 2;
        }
    }
}
