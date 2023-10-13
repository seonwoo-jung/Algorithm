package inflearn.string;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.System.in;

/**
 * 봉우리 구하기
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    static int solution(int n, int[][] arr) {
        // 행을 i로, 열을 j로 탐색할 때, 시계 방향으로 돔
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true; // ?
                // 상하좌우 크기 검증
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // 참조하지 못하도록 앞에서 검증
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }
}