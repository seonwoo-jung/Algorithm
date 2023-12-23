package programmers.level_1;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main31 {

    public static void main(String[] args) {
        String[] arr = {
            ".##...##.",
            "#..#.#..#",
            "#...#...#",
            ".#.....#.",
            "..#...#..",
            "...#.#...",
            "....#...."
        };
        int[] solution = solution(arr);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    static int[] solution(String[] wallpaper) {
        int x_min = MAX_VALUE, x_max = MIN_VALUE, y_min = MAX_VALUE, y_max = MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char x = wallpaper[i].charAt(j);
                if (x == '#') {
                    x_min = min(i, x_min);
                    x_max = max(i, x_max);
                    y_min = min(j, y_min);
                    y_max = max(j, y_max);
                }
            }
        }
        return new int[]{x_min, y_min, x_max + 1, y_max + 1};
    }
}