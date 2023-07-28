package programmers.level_0;

public class Main53 {

    public static void main(String[] args) {
        solution("bus");
    }

    static String solution(String my_string) {
        return my_string.replaceAll("[a, e, i, o, u]", "");
    }
}