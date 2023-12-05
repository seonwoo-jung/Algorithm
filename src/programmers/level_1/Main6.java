package programmers.level_1;

import java.util.ArrayList;

public class Main6 {

    public static void main(String[] args) {
        int[][] data = {
            {1, 20300104, 100, 80},
            {2, 20300804, 847, 37},
            {3, 20300401, 10, 8}
        };

        ArrayList<Data> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
    }

    static class Data implements Comparable<Data> {

        private int code, date, maximum, remain;

        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }

        @Override
        public int compareTo(Data o) {

            return 0;
        }
    }
}
