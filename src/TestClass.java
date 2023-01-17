import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {
        // 약수 구하기
        solution(new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});

    }

    static int solution(int[] a) {

        int[] array = Arrays.stream(a).filter(value -> value != 4).toArray();
        
        for (int b : array) {
            System.out.println("b = " + b);
        }
        return 0;
    }
}
