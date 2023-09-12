package programmers.level_0;

import java.util.Scanner;

public class Main75 {

    // BMI 공식: kg * (m * m)
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        double height = stdIn.nextDouble(); // 키
        double weight = stdIn.nextDouble(); // 체중
        height = height / 100.0; // 미터로 변환
        int result = (int) (weight / (height * height));
        System.out.println(result);
        if (result > 25) {
            System.out.println("Obesity");
        }
    }
}