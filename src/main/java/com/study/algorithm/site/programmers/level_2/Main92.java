package com.study.algorithm.site.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main92 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3, 5)));
	}

	private static int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();

		// f: n명의 사람이 있을 때의 n! 값, 즉 팩토리얼을 계산하기 위한 변수입니다.
		long f = 1;

		for (int i = 1; i <= n; i++) {
			list.add(i);
			f *= i;
		}

		k--;
		int idx = 0;

		while (idx < n) {
			// f = f / (n - idx): 현재 자리에 올 수 있는 사람의 경우의 수를 구하기 위해 팩토리얼 값을 줄여 나갑니다. 예를 들어, 첫 번째 자리는 (n-1)!개의 경우의 수를 가지며, 두 번째 자리는 (n-2)!개의 경우의 수를 갖는 방식입니다.
			f = f / (n - idx);
			// k / f를 통해 현재 k번째에 올 수 있는 사람의 번호를 결정합니다. 예를 들어, 첫 번째 자리에 올 수 있는 사람은 (n-1)! 단위로 변하므로, 이를 통해 어떤 사람이 첫 번째 자리에 와야 할지 결정합니다.
			answer[idx++] = list.remove((int) (k / f));
			k = k % f;
		}

		return answer;
	}
}