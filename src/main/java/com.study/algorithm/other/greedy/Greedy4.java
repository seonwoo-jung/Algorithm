package other.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.in;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

/**
 * 최대수입스케줄
 */
public class Greedy4 {

    static int n, max = MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if (d > max) max = d;
        }
        System.out.println(solution(arr));
    }

    static int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(reverseOrder());
        sort(arr);
        int j = 0;
        for (int i = max; i >= 1 ; i--) {
            for ( ; j < n; j++) {
                if (arr.get(j).time < i) break;
                    pQ.offer(arr.get(j).money);
                }
            if (!pQ.isEmpty()) answer += pQ.poll();
            }

        return answer;
    }

    static class Lecture implements Comparable<Lecture> {
        private int money, time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }
}
