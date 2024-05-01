package programmers.level_1;

import java.util.Arrays;

/**
 * 하샤드 수
 */
public class Main14 {

    public static void main(String[] args) {
        System.out.println(solution(18));
    }

    static boolean solution(int x) {
        int sum = Arrays.stream(Integer.toString(x).split("")).mapToInt(Integer::parseInt).sum();
        return x % sum == 0;
    }
}
