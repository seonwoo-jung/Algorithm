package Level_0;

import java.util.*;
import java.util.stream.Collectors;

public class Main20 {
	public static void main(String[] args) {
		System.out.println(solution2("hello", 1, 2));
	}

	static String solution(String my_string, int num1, int num2) {

		char[] chars = my_string.toCharArray();

		char temp = chars[num1];

		chars[num1] = chars[num2];
		chars[num2] = temp;

		return String.valueOf(chars);
	}

	static String solution2(String my_string, int num1, int num2) {

		// String -> List
		List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());

		// num1 index 문자열과 num2 index 문자열이 교환된다.
		Collections.swap(list, num1, num2);

		// List를 iterator 돌려서 합침
		return String.join("", list);
	}
}
