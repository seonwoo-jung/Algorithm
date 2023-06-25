package algorithm.ch01;

import java.util.Scanner;

import static java.lang.System.in;

public class Max3Method {
    static int max3(int a, int b, int c) {
        int max = a; // 최댓값

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(max3(3, 2, 1));
        System.out.println(max3(3, 2, 2));
        System.out.println(max3(3, 1, 2));
        System.out.println(max3(3, 2, 3));
        System.out.println(max3(2, 1, 3));
        System.out.println(max3(3, 3, 2));
        System.out.println(max3(3, 3, 3));
        System.out.println(max3(2, 2, 3));
        System.out.println(max3(2, 3, 1));
        System.out.println(max3(2, 3, 2));
        System.out.println(max3(1, 3, 2));
        System.out.println(max3(2, 3, 3));
        System.out.println(max3(1, 2, 3));
    }
}
