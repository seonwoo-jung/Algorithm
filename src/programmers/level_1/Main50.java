package programmers.level_1;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.sort;

import java.util.ArrayList;
import java.util.List;

public class Main50 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},
                            {4, 4, 1},
                            {1, 7, 3}};
        int[] result = solution(array, commands);
    }

    static int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            int s = commands[i][0] - 1;
            int e = commands[i][1];
            int t = commands[i][2] - 1;
            int[] arr = copyOfRange(array, s, e);
            sort(arr);
            list.add(arr[t]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}