package Level_0;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main19 {
	public static void main(String[] args) {
		System.out.println(solution("hello"));
	}

	static String solution(String s) {
		return Arrays.stream(s.split(""))
							  .collect(Collectors.groupingBy(s1 -> s1))
							  .entrySet()
							  .stream()
							  .filter(entry -> entry.getValue().size() <= 1)
							  .map(Map.Entry::getKey)
							  .sorted()
							  .collect(Collectors.joining());
	}
}
