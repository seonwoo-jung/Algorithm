package other.study.inflearn_code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int typesOfCoin = in.nextInt();

        int[] coins = new int[typesOfCoin];

        for (int i = 0; i < typesOfCoin; i++) coins[i] = in.nextInt();

        int target = in.nextInt();

        int[] check = new int[target + 1];

        System.out.println(BFS(target, typesOfCoin, coins, check));
    }

        static int BFS(int target, int typesOfCoin, int[] coins, int[] check) {
            Queue<Integer> q = new LinkedList<>();
            check[target] = 1;
            q.offer(target);
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int exchange = q.poll();
                    for (int j = 0; j < typesOfCoin; j++) {
                        int nextExchange = exchange - coins[j];
                        if (nextExchange > 0 && check[nextExchange] == 0) {
                            check[nextExchange] = 1;
                            q.offer(nextExchange);
                        } else if (nextExchange == 0) return (level + 1);
                    }
                }
                level++;
            }
            return (-1);
        }
}
