package programmers.level_0;

public class Main63 {

    public static void main(String[] args) {
        int[] emergency = {3, 76, 24};
        int[] solution = solution(emergency);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            int rank = 1;
            for (int j = 0; j < emergency.length; j++) {
                if (emergency[i] < emergency[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }
}