package inflearn;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;
import static java.lang.System.in;

public class Main {
    public static int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = toUpperCase(t);

        // String -> char[] 변환
        for (char x : str.toCharArray()) {
            if (x == t) answer++;
        }

        // 인덱스 접근 방식
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == t) {
//                answer++;
//            }
//        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(solution(str, c));
    }
}
