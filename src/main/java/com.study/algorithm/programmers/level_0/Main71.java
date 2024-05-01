package programmers.level_0;

public class Main71 {

    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5};
        solution(num_list);
    } 

    static int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for (int i = 0; i < num_list.length; i++) {
            answer[num_list[i] % 2]++;
        }

        return answer;
    }
}