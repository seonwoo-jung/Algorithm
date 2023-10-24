package programmers.level_0;

public class Main87 {
    public static void main(String[] args) {
        int[] solution = solution(1, 2, 3, 4);
        for (int x : solution) {
            System.out.println("x = " + x);
        }
    }

    // 분자, 분모 / 분자, 분모
    static int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        int max = 1;

        for (int i = 1; i <= numer && i <= denom; i++) {
            if (denom % i == 0 && numer % i == 0) {
                max = i;
            }
        }

        numer = numer / max;
        denom = denom / max;

        int[] answer = {numer, denom};

        return answer;
    }
}