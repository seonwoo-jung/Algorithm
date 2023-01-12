package Level_0;

import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {

        int startNum = 1;
        solution(startNum, 10, 100);
    }

    static int solution(int startNum, int num, int total) {

        while (true) {

            int[] result = searchNumber(startNum, num, total);

            if (result != null) {

                System.out.println("result = " + result);
                return 1;
            } else {
                startNum++;

            }
        }
    }
    static int[] searchNumber(int startNum, int num, int total) {

        int[] array = new int[num];
        int sum = 0;

        for (int i = 0; i < num; i++) {
            array[i] = startNum;
            sum += array[i];
            startNum++;
        }

        if (total == sum) {
            return array;
        } else {
            return null;
        }
    }

}
