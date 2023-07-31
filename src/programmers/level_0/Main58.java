package programmers.level_0;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Main58 {

    public static void main(String[] args) {
        int[] param = {4, 455, 6, 4, -1, 45, 6};
        String direction = "left";
        solution2(param, direction);
    }

    static int[] solution(int[] numbers, String direction) {

        int[] temp = new int[numbers.length];

        if (direction.equals("left")) {
            for (int i = 1; i < numbers.length; i++) {
                temp[i - 1] = numbers[i];
            }
            temp[numbers.length - 1] = numbers[0];

        } else if (direction.equals("right")) {
            for (int i = 0; i < numbers.length - 1; i++) {
                temp[i + 1] = numbers[i];
            }
            temp[0] = numbers[numbers.length - 1];
        }
        for (int i : temp) {
            System.out.println("i = " + i);
        }
        return temp;
    }

    static int[] solution2(int[] numbers, String direction) {
        // 배열 -> list로 변환
        List<Integer> list = Arrays.stream(numbers).boxed().collect(toList());

        // 첫 번째 인덱스에 마지막 요소를 추가하고, 마지막 인덱스의 요소를 삭제한다.
        if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        // 마지막 인덱스에 첫 번째 요소를 추가하고, 첫 번째 인덱스의 요소를 삭제한다.
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        // list -> 배열로 변환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}