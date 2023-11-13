package inflearn.ch05;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

/**
 * 괄호문자제거
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        String str = kb.next();
        String solution = solution(str);
        System.out.println("solution = " + solution);
    }

    static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
        return stack.toString();
    }
}