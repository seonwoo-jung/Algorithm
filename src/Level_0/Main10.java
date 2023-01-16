package Level_0;

public class Main10 {

    public static void main(String[] args) {

        System.out.println(solution("ab6CDE443fgh22iJKlmn1o", "6CD"));
    }

    /**
     * contains method() 활용
     */
    static int solution(String str1, String str2) {

        if (str1.contains(str2)) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * indexOf method() 활용
     */
    static int solution2(String str1, String str2) {

        if (str1.indexOf(str2) == -1) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * matches method() 활용 (정규 표현식)
     */
    static int solution3(String str1, String str2) {
        System.out.println("(.*)" + str2 + "(.*)");
        if (str1.matches("(.*)" + str2 + "(.*)")) {
            return 2;
        } else {
            return 1;
        }
    }
}
