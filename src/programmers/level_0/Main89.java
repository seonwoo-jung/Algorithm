package programmers.level_0;

import static java.util.Arrays.sort;

// 최빈값 구하기
public class Main89 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4};
        solution(arr);
    }

    static int solution(int[] array) {
        int answer = 0;

        sort(array);
        // 배열의 마지막 값을 변수 max에 입력
        int max = array[array.length - 1];

        // 배열 array의 최대값에 + 1
        int[] count = new int[max + 1];

        // array.length == 6
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        /**
         * count[1]++;
         * count[2]++;
         * count[3]++;
         * count[3]++;
         * count[3]++;
         * count[4]++;
         */

        // 배열 count에 숫자가 count 된 거임
        for (int i = 0; i < count.length; i++) {
            System.out.printf("count[%d] = %d\n", i, count[i]);
        }

        int top = count[0]; // top: 0

        for (int i = 1; i < count.length; i++) {
            // top보다 count값이 크면 top에 넣는다.
            if (top < count[i]) {
                top = count[i];
                answer = i; // answer에 i값을 넣는다
            } else if (top == count[i]) {
                answer = -1;
            }
        }

        return answer; // 최빈값 return
    }
}