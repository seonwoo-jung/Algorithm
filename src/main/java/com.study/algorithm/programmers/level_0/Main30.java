package programmers.level_0;

public class Main30 {
    public static void main(String[] args) {
//        System.out.println(solution("1011", "1111"));

        System.out.println(Integer.toString(Integer.parseInt("1011", 2) + Integer.parseInt("1111", 2), 2));
    }

    public static String solution(String bin1, String bin2) {
        int decimalBin1 = convertDecimal(bin1);
        int decimalBin2 = convertDecimal(bin2);

        int result = decimalBin1 + decimalBin2;

        return convertBinary(result);
    }

    private static int convertDecimal(String param) {
        int sum = 0;
        int index = 0;

        String[] array = param.split("");

        for (int i = param.length() - 1; i >= 0; i--) {
            sum += Integer.parseInt(array[i]) * Math.pow(2, index);
            index++;
        }
        return sum;
    }

    private static String convertBinary(int param) {
        return Integer.toBinaryString(param);
    }
}
