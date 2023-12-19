package programmers.level_1;

public class Main22 {

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        String solution = solution(seoul);
        System.out.println("solution = " + solution);
    }

    static String solution(String[] seoul) {
        String answer = "김서방은 0에 있다";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) return answer.replaceAll("0", String.valueOf(i));
        }
        return answer;
    }
}
