package programmers.level_0;

import java.util.ArrayList;

import static java.util.Collections.sort;

public class Main50 {

    public static void main(String[] args) {

    }

    static int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            while(n % i == 0) {
                list.add(i);
                n /= i;
            }
        }

        sort(list);

        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}