package programmers.level_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        solution(
                new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"}
                );
    }

    static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < )

        for (int i = 1; i <= players.length; i++) {
            map.replace(callings[i - 1], map.get(players) + 1);
        }

        return answer;
    }
}
