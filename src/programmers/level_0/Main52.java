package programmers.level_0;

import static java.util.Arrays.stream;

public class Main52 {

    public static void main(String[] args) {
        int[] hi12392s = solution("hi12392");
        for (int hi12392 : hi12392s) {
            System.out.println("hi12392 = " + hi12392);
        }
    }

    static int[] solution(String my_string) {
        String[] split = my_string.replaceAll("[^0-9]", "").split("");
        return stream(split).mapToInt(Integer::parseInt).sorted().toArray();
    }
}