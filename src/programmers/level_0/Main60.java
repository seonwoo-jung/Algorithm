package programmers.level_0;

public class Main60 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 2;
        solution(numbers, n);
    }

    static int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int k = 0;
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = num_list[k++];
            }
        }
        return answer;
    }
}