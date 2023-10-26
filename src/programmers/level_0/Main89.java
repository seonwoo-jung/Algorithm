package programmers.level_0;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

// 최빈값 구하기
public class Main89 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4};
        int i = solution2(arr);
        System.out.println("i = " + i);
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

    static int solution2(int[] array) {
        int maxCount = 0;
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // 1, 2, 3, 3, 3, 4 순으로 for문 실행
        for (int number : array) {
            int count = map.getOrDefault(number, 0) + 1;
            System.out.println("count = " + count);

            if (count > maxCount) {
                maxCount = count;   // count 값
                answer = number;    // 배열의 실제 값
            } else if (count == maxCount) {
                answer = -1;
            }
            // 배열의 count 값을 map에 담는다.
            map.put(number, count);
        }
        return answer;
    }
}