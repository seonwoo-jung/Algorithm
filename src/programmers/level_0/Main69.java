package programmers.level_0;

public class Main69 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        solution(numbers);
    } 

    static int solution(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double result = (double) sum / numbers.length;
        System.out.println("result = " + result);
        return 0;
    }
}