package p230111;

import java.util.Arrays;

public class 옹알이 {

    public static void main(String[] args) {

        // 객체 생성
        Solution solution = new Solution();
        // 파라미터 전달
        String[] parameter = {"yeeee", "dnnnln", "zzzzlz"};
        int result = solution.solution(parameter);
        System.out.println("result = " + result);
    }
}

class Solution {
    public int solution(String[] babbling) {

        int answer = 0;
        String[] speakWord = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < speakWord.length; i ++) {
            if (Arrays.asList(babbling).contains(speakWord[i])) {
                answer++;
            }
        }
        return answer;
    }
}
