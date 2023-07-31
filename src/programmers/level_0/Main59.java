package programmers.level_0;

public class Main59 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int k = 3;
        System.out.println(solution(numbers, k));
    }

    static int solution(int[] numbers, int k) {

        int thrower = 0;
        int index = numbers.length - 1;
        k = k > 1 ? k - 1 : k;

        while (k > 0) {
            if (thrower < index - 1) {
                thrower += 2;
            } else if (thrower == index - 1) {
                thrower = 0;
            } else if (thrower == index) {
                thrower = 2;
            }
            k--;
        }

        return numbers[thrower];

    }
}