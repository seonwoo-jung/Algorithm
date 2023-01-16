import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {
        // 약수 구하기
        solution(12);

    }

    static int solution(int a) {

        int[] x;

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.println("i = " + i);
            }
        }

        return 0;
    }
}
