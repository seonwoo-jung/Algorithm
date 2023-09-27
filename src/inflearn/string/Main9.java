package inflearn.string;

import java.util.Scanner;

import static java.lang.System.in;

public class Main9 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        System.out.println(solution3(kb.nextLine()));
        // input: g0en2T0s8eSoft
    }

    static String solution(String str) {
        str = str.replaceAll("[^0-9]", "");
        return str.charAt(0) == '0' ? str.substring(1) : str;
    }
    // 숫자(0~9)의 아스키 코드는 48 ~ 57
    static int solution2(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }

    static int solution3(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer); // 0208 -> 208 (0이 사라짐)
    }
}