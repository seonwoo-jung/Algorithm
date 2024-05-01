package inflearn.ch05;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

/**
 * 올바른 괄호 (Stack)
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        String str = kb.next();
        String solution = solution(str);
        System.out.println("solution = " + solution);
    }

    private static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        return stack.isEmpty() == true ? "YES" : "NO";
    }
}
