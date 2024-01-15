package programmers.level_1;

import java.util.ArrayList;
import java.util.Collections;

public class Main48 {

    public static void main(String[] args) {
        String[] arr = {"abce", "abcd", "cdx"};
        String[] solution = solution(arr,2);
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

    static String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}