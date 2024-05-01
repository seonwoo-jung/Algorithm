package algorithm.ch05;

import java.util.Scanner;

import static java.lang.System.in;

public class EuclidGCD {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

        System.out.print("정수를 입력하세요.: ");
        int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd2(x, y) + "입니다.");

        int[] intArr = {10, 12, 14, 16};
        System.out.println(findArrayGCD(intArr));
    }

    // 재귀방식
    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    // 반복문 방식
    static int gcd2(int x, int y) {

        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }

        return x;
    }

    static int findArrayGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd2(result, arr[i]);
        }
        return result;
    }
}
