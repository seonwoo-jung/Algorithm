package programmers.level_0;

public class Main43 {

    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
    }

    /**
         1. aAb
         2. 1
         3. B
         4. 2
         5. cC
         6. 34
         7. oOp
     */


    static int solution(String my_string) {

        int answer = 0;
        String[] ms = my_string.split("[a-zA-Z]");

        for (String data : ms) {
            System.out.println("data = " + data);
        }

        for (int i = 0; i < ms.length; i++) {
            answer += !ms[i].isEmpty() ? Integer.parseInt(ms[i]) : 0;
        }

        return answer;
    }
}