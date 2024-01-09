package programmers.level_1;

public class Main41 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] solution = solution(lottos, win_nums);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_cnt = 0, rank = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == 0) {
                    zero_cnt++;
                    break;
                } else if (lottos[i] == win_nums[j]) {
                    rank++;
                    break;
                }
            }
        }
        int max_rank = zero_cnt + rank;
        int min_rank = rank;

        answer[0] = getGrade(max_rank);
        answer[1] = getGrade(min_rank);

        return answer;
    }

    private static int getGrade(int num) {
        switch (num) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}