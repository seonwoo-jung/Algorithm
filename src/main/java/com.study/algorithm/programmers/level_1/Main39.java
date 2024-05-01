package programmers.level_1;

public class Main39 {
    public static void main(String[] args) {
        String[] param = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        for (String s : param) {
            int solution = solution(s);
            System.out.println("solution = " + solution);
        }
    }

    static int solution(String dartResult) {
        int answer = 0;
        String[] dart = dartResult.split("");
        int[] score = new int[3];
        int idx = -1;
        for (int i = 0; i < dart.length; i++) {
            if (dart[i].matches("[0-9]")) {
                idx++;
                score[idx] = Integer.parseInt(dart[i]);
                if (dart[i + 1].matches("[0-9]")) {
                    score[idx] *= 10;
                    i++;
                }
            }
            switch (dart[i]) {
                case "D":
                    score[idx] = (int) Math.pow(score[idx], 2);
                    break;
                case "T":
                    score[idx] = (int) Math.pow(score[idx], 3);
                    break;
                case "*":
                    score[idx] *= 2;
                    if (idx - 1 >= 0) score[idx - 1] *= 2;
                    break;
                case "#":
                    score[idx] *= -1;
            }
        }
        for (int s : score) {
            answer += s;
        }
        return answer;
    }
}


