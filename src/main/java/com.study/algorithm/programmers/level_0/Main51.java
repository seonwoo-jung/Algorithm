package programmers.level_0;

import static java.util.Arrays.stream;

public class Main51 {

    public static void main(String[] args) {
        int solution = solution("aAb1B2cC34oOp");
        System.out.println("solution = " + solution);
    }

    static int solution(String my_string) {

        String[] replaceStr = my_string.replaceAll("[^0-9]", "").split("");
        int sum = stream(replaceStr).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}