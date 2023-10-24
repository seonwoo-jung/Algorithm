package programmers.level_0;

public class Main88 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 2},
                {-3, -1},
                {-2, 1}
        };
        int solution = solution(arr);
        System.out.println("solution = " + solution);
    }

    static int solution(int[][] dots) {
        // 1. arr 배열 및 변수 초기화
        int answer = 0;
        int[] arr = new int[200];

        // 2. lines 정보를 arr 배열에 적용
        for (int i = 0; i < dots.length; i++) {
            for (int j = dots[i][0] + 100; j < dots[i][1] + 100; j++) {
                arr[j]++;
            }
        }

        // 3. arr 배열에서 겹친 부분 세기
        for (int i = 0; i < 200; i++) {
            if (arr[i] > 1) {
                answer++;
            }
        }

        return answer;
    }
}