package programmers.level_0;

// 나중에 다시 볼 것
public class Main3 {

    public static void main(String[] args) {

        for(int intArr : solution(5, 5)) {
            System.out.println("arr = " + intArr);
        }
    }

    static int[] solution(int num, int total) {
        int[] answer = new int[num];

        int nSum = num * (1 + num) / 2;
        int start = (total - nSum) / num;

        for (int i = 1; i < num + 1; i++) {
            answer[i - 1] = i + start;
        }

        return answer;
    }

}
