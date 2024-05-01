package programmers.level_0;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;

public class Main34 {
    public static void main(String[] args) {
        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;
        solution(numlist, n);
    }

    static int[] solution(int[] numlist, int n) {

        int[] answer = new int[numlist.length];
        double[] order = new double[numlist.length];

        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] - n < 0) {
                order[i] = ((int) abs(numlist[i] - n)) + 0.5;
            } else {
                order[i] = numlist[i] - n;
            }
        }

        sort(order);

        for (int i = 0; i < numlist.length; i++) {
            if (order[i] % 1 != 0) {
                answer[i] = n - (int) order[i];
            } else {
                answer[i] = (int) order[i] + n;
            }
        }
        return answer;
    }
}
