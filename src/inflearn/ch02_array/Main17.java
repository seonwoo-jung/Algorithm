package inflearn.ch02_array;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 소수(에라토스테네스 체): 체크해서 걸러낸다
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();

        int solution = solution(n);
        System.out.println("solution = " + solution);
    }

    static int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];

        // 2의 배수는 소수가 아님
        // 2 ~ n까지 for문 시작
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) ch[j] = 1;
            }
        }
        return answer;
    }
}