package programmers.level_0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main29 {
    public static void main(String[] args) {
        System.out.println(solution("allpe", "apple"));
    }

    public static int solution(String before, String after) {
        String before2 = sortString(before);
        String after2 = sortString(after);

        return before2.equals(after2) ? 1 : 0;
    }

    private static String sortString(String param) {
        return Arrays.stream(param.split("")).sorted().collect(Collectors.joining());
    }
}
