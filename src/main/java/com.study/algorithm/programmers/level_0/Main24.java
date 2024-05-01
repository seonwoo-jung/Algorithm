package programmers.level_0;

public class Main24 {
    public static void main(String[] args) {
        System.out.println(solution(294230));
    }

    static int solution(int order) {
        int answer = 0;
        String buffer = String.valueOf(order);

        int[] array = {1, 2, 3};

        for (int i = 0; i < buffer.length(); i++) {
            int temp = Integer.valueOf(buffer.substring(i, i + 1));
            if (temp != 0 && temp % 3 == 0) {
                System.out.println("temp = " + temp);
                answer++;
            }
        }
        return answer;
    }
}
