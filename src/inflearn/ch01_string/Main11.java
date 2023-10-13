package inflearn.ch01_string;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * input: KKHSSSSSSSE
 * output: K2HS7E
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        String str = kb.next();
        System.out.println(solution(str));
    }

    static String solution(String s) {
        String answer = "";
        s= s + " ";
        int cnt = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
            } else {
                answer += s.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                    // 또는 Integer.toString();
                }
            }
        }
        return answer;
    }
}