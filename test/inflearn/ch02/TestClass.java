package inflearn.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {

	static boolean isPrime(int num) {
		if (num == 1) return false;
		for (int i = 2; i < num; i++) {
			// 2부터 num 전까지의 수로 나눠지지 않으면 소수임
			if (num % i == 0) return false;
		}
		return true;
	}

	@Test
	void hiJunit() {
		System.out.println("Hi!");
	}

	@Test
	@DisplayName("에라토스테네스 체로 소수를 구한다")
	void test() {
		int answer = 0;
		int n = 14;

		int[] ch = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			if (ch[i] == 0) {
				answer++;
				for (int j = i; j <= n; j = j + i) {
					ch[j] = 1;
				}
			}
		}
		assertThat(answer).isEqualTo(6);
	}

	@Test
	@DisplayName("특정 값이 소수인지 확인한다.")
	void validatePrime() {
		assertThat(isPrime(17)).isTrue();
	}
}
