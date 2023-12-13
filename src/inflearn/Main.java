package inflearn;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        // 1000011
        int x = 1000011, val = 1, sum = 0, k = 2;

        while (x > 0) {
            int tmp = x % 10;
            sum = sum + tmp * val;
            x /= 10;
            val *= k;
        }



        System.out.println("sum = " + sum);

        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        String s = kb.next();
        String solution = solution(n, s);
        System.out.println(solution);
    }

    static String solution(int n, String s) {
        s = s.replace("#", "1")
             .replace("*", "0");

        while (!s.isEmpty()) {
            String tmp = s.substring(0, 7);
            int x = Integer.parseInt(tmp) % 10;

            int pow = (int) pow(2, 2);
            System.out.println("pow = " + pow);

            System.out.println("tmp = " + tmp);
            s = s.substring(7);
        }

        return s;
    }
}
