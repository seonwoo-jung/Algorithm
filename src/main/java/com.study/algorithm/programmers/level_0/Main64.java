package programmers.level_0;

import java.util.HashMap;

public class Main64 {

    public static void main(String[] args) {
        System.out.println(solution(23));
    }

    static String solution(int age) {
        HashMap<String, String> map = new HashMap<>();
        map.put("0", "a");
        map.put("1", "b");
        map.put("2", "c");
        map.put("3", "d");
        map.put("4", "e");
        map.put("5", "f");
        map.put("6", "g");
        map.put("7", "h");
        map.put("8", "i");
        map.put("9", "j");
        String[] split = Integer.toString(age).split("");
        StringBuffer sb = new StringBuffer();
        for (String temp : split) {
            sb.append(map.get(temp));
        }

        return sb.toString();
    }
}