package Level_0;

import java.util.ArrayList;

public class Main13 {

    public static void main(String[] args) {
		for (int a : solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})) {
			System.out.println("a = " + a);
		};
    }

	static int[] solution(int n, int[] numlist) {

		int result = 0;

		for (int i = 0; i < numlist.length; i++) {
			for (int k = 0; k <= 10000; k++) {
				result += n;
				if(numlist[i] == result) {
					numlist[i] = 0;
				}
			}
		}

		return numlist;
	}
}