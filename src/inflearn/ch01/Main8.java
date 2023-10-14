package inflearn.ch01;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 팰린드롬: 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 의미
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        System.out.println(solution(kb.nextLine()));
        // found7, time: study; Yduts; emit, 7Dnuof
    }

    static String solution(String str) {
        str = str.replaceAll("[^a-zA-Z]", "");
        String sb = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(sb)) {
            return "YES";
        }
        return "NO";
    }
}