package programmers.level_1;

import java.util.ArrayList;
import java.util.List;

public class Main11 {

    public static void main(String[] args) {
        long n = 12345;
        int[] solution = solution(n);
        for (int x : solution) {
            System.out.println("x = " + x);
        }
    }

    static int[] solution(long n) {
        List<Long> list = new ArrayList<>();
        while (n % 10 != 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list.stream().mapToInt(Integer::parseInt).toArray();
    }
}
