package inflearn.ch07;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main6Test {

    static int[] ch;

    @Test
    @DisplayName("배열 중 세 가지를 뽑은 최대 합 구하기")
    void searchSum() {
        int[] arr = {4, 7, 6, 8, 9, 5};
        ch = new int[arr.length + 1];
        DFS(1, arr.length, arr);
    }

    static void DFS(int L, int len, int[] arr) {
        if (L == len) {
            String tmp = "";
            for (int i = 0; i <= len; i++) {
                if (ch[i] == 1) {
                    tmp += (i + "");
                }
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[L] = 1;
            DFS(L + 1, len, arr);
            ch[L] = 0;
            DFS(L + 1, len, arr);
        }
    }

}