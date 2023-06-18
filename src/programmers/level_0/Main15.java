package Level_0;

import java.util.Arrays;

public class Main15 {

	public static void main(String[] args) {
		solution("3 + 5");
	}

	static int solution(String my_string) {
		return Arrays.stream(my_string.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
	}
}
