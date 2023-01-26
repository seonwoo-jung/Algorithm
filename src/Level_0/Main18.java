package Level_0;

import java.util.ArrayList;
import java.util.List;

public class Main18 {
	public static void main(String[] args) {
		solution(24);
	}

	static int[] solution(int n) {
		List<Integer> A = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				A.add(i);
			}
		}

		return A.stream().mapToInt(Integer::intValue).toArray();
	}
}
