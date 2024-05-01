package inflearn.ch07;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 재귀함수 (자기 자신을 호출한다. 반복문의 형태, if-else 구조를 사용)
 * 스택 프레임에 매개변수 정보, 지역변수 정보, 복귀주소가 생긴다.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        DFS(n);
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", i);
        }
    }

    static void DFS(int n) {

        if (n == 0) {

        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
}
