package algorithm.ch01;

import java.util.Scanner;

import static java.lang.System.in;

public class JudgeSign {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(in);

        System.out.print("정수를 입력하세요.");
        int n = stdIn.nextInt();

        if (n > 0) {
            System.out.println("이 수는 양수입니다.");
        } else if (n < 0) {
            System.out.println("이 수는 음수입니다.");
        } else {
            System.out.println("이 수는 0입니다.");
        }
    }
}
