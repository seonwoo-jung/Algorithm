package programmers.level_0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main16 {
	public static void main(String[] args) {
		solution2(new int[] {1, 8, 3});
	}

	static int[] solution(int[] array) {

		int result = Arrays.stream(array).max().getAsInt();
		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

		return new int[]{result, list.indexOf(result)};
	}

	static int[] solution2(int[] array) {
		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
		int max = list.stream().max(Integer::compareTo).orElse(0);
		int index = list.indexOf(max);
		return new int[] {max, index};
	}
}
