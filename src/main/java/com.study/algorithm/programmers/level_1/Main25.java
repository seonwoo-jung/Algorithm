package programmers.level_1;

public class Main25 {

    public static void main(String[] args) {
        String phone_number = "027778888";
        String solution = solution(phone_number);
        System.out.println("solution = " + solution);
    }

    static String solution(String phone_number) {
        String str = phone_number.substring(phone_number.length() - 4, phone_number.length());
        String answer = "";
        int star_len = phone_number.length() - 4;
        for (int i = 0; i < star_len; i++) {
            answer += "*";
        }

        return answer + str;
    }
}
