package inflearn.ch05;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

/**
 * 쇠막대기
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        String str = kb.next();
        System.out.println("solution = " + solution(str));
    }

    static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')' && stack.peek() == '(') {
                stack.pop();
                answer += stack.size();
            } else {
                stack.push(x);
            }
        }

        return answer;
    }
}