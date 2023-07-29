package programmers.level_0;

public class Main57 {

    public static void main(String[] args) {
        int[] param = {10, 8, 6};
        int n = 3;
        System.out.println(solution(param, n));
    }

    static int solution(int[] box, int n) {
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }
}