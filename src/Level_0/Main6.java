package Level_0;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {

    public static void main(String[] args) {

        int[] intArr = {7, 77, 17};
        solution(intArr);
    }

    static int solution(int[] array) {

        int answer = 0;

        for (int i = 0; i < array.length; i++) {

            String arr = String.valueOf(array[i]);

            arr.chars()
                    .count();

        }

        return answer;
    }
}
