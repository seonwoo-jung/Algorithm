package other;

import static java.lang.Integer.*;
import static java.lang.Integer.toBinaryString;

public class NumberConvert {
    public static void main(String[] args) {
        int decimal = 10;
        System.out.println(toBinaryString(decimal)); // 10진수 -> 2진수
        System.out.println(toOctalString(decimal)); // 10진수 -> 8진수
        System.out.println(toHexString(decimal)); // 10진수 -> 16진수
        System.out.println(parseInt("1000011", 2)); // 2진수 -> 10진수
    }
}
