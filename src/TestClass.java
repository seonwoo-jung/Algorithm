import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {

    public static void main(String[] args) {
        // 약수 구하기
        solution(new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});

    }

    static int solution(int[] a) {

        IntStream intStream = Arrays.stream(a);
        intStream.limit(5).sorted().forEach(System.out::println);


        return 0;
    }
}
