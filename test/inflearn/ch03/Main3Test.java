package inflearn.ch03;

import org.junit.jupiter.api.Test;

import static java.lang.Math.max;
import static org.assertj.core.api.Assertions.assertThat;

class Main3Test {

    @Test
    void slidingWindow() {
        int n = 9, k = 3;
        int[] arr = {3, 4, 6, 4, 7, 2, 6, 5, 4};

        int answer, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        answer = sum;

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = max(answer, sum);
        }

        assertThat(answer).isEqualTo(17);
    }
}