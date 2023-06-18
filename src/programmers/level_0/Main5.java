package Level_0;

public class Main5 {

    public static void main(String[] args) {
        System.out.println(solution("apple", "elppa"));
    }

    static int solution(String A, String B) {

        int answer = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.equals(B)) {
                return answer;
            }

            A = A.substring(A.length() - 1) + A.substring(0, A.length() - 1);
            System.out.println("A = " + A);

            answer++;
        }

        return -1;
    }
}
