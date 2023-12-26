package other.study.lambda;

import java.util.function.IntBinaryOperator;

import static other.study.lambda.MethodReferencesExample.Calculator.staticMethod;

public class MethodReferencesExample {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        operator = (x, y) -> staticMethod(x, y);
        System.out.println("결과1: " + operator.applyAsInt(1, 2));

        operator = Calculator :: staticMethod;
        System.out.println("결과2: " + operator.applyAsInt(3, 4));

        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println("결과3: " + operator.applyAsInt(5, 6));

        operator = obj :: instanceMethod;
        System.out.println("결과4: " + operator.applyAsInt(7, 8));

    }

    static class Calculator {
        static int staticMethod(int x, int y) {
            return x + y;
        }
        int instanceMethod(int x, int y) {
            return x + y;
        }
    }
}
