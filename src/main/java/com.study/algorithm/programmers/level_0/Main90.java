package programmers.level_0;

import java.util.ArrayList;
import java.util.List;

/**
 * 평행
 */
public class Main90 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4},
                {9, 2},
                {3, 8},
                {11, 6}
        };
        solution(arr);
    }

    static int solution(int[][] dots) {
        int answer = 0;

        List<Double> slopes = new ArrayList<>();

        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = i + 1; j < dots.length; j++) {

                double sideX = dots[i][1] - dots[j][1];
                double sideY = dots[i][0] - dots[j][0];

                System.out.println("sideX = " + sideX + " sideY = " + sideY);

                // 직선의 기울기 계산
                double slop = sideY / sideX;
                System.out.println("slop = " + slop);
                System.out.println();

                if (!slopes.contains(slop)) {
                    slopes.add(slop);
                } else {
                    answer = 1;
                    break;
                }
            }
            if (answer == 1) {
                break;
            }
        }
        return answer;
    }
}