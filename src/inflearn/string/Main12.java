package inflearn.string;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * input1: 4
 * input2: #****###**#####**#####**##**
 * output: K2HS7E
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int num = kb.nextInt();
        String str = kb.next();
        System.out.println(solution2(num, str));
    }

    static String solution(int i, String s) {
        String answer = "";
        s = s.replaceAll("#", "1").replaceAll("\\*", "0");
        int len = s.length() / i;
        while (s.length() >= len) {
            String subStr = s.substring(0, len);
            answer += (char) Integer.parseInt(subStr, 2);
            s = s.substring(len);
        }
        return answer;
    }

    // 1. replace와 replaceAll의 차이
    // 2. substring index의 정확한 이해가 필요
    // 운동하고 와서 다시 봐야징 ^-^
    static String solution2(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s = s.substring(7);
        }
        return answer;
    }
}