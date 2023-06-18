package Level_0;

public class Main9 {

    public static void main(String[] args) {

        System.out.println(solution2(3));
    }

    static int solution(int n) {

        int result;

        for (int i = 0; i < n; i++) {

            result = i * i;

            if (result == n) {
                return i;
            }
        }

        return 2;

    }

    static int solution2(int n) {

        if (n % Math.sqrt(n) == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
