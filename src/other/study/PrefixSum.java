package other.study;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * 누적합 (누적합 배열은 1번째 부터 시작함)
 */
public class PrefixSum {

    static int s, e;

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        s = sc.nextInt(); // 시작 지점
        e = sc.nextInt(); // 종료 지점

        System.out.println(solution(arr));
    }

    static int solution(int[] arr) {

        int[] psum = new int[10];

        for (int i = 1; i < arr.length; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }

        return psum[e] - psum[s - 1];
    }
}
