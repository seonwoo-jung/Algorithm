package programmers.level_0;

public class Main6 {

    public static void main(String[] args) {

        int[] intArr = {7, 77, 17};
        solution(intArr);
    }

    static int solution(int[] array) {

        int answer = 0;

        for (int i = 0; i < array.length; i++) {

            for (int k = 0; k < String.valueOf(array[i]).length(); k++) {

                if (String.valueOf(String.valueOf(array[i]).charAt(k)).equals("7")) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
