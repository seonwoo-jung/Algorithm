package other.study.inflearn_code;

import java.time.Instant;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.time.Duration.between;

public class MemoCombi {

	static int[][] dy = new int[35][35];

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		Instant beforeTime = Instant.now();
		int dfs = DFS(n, m);
		Instant afterTime = Instant.now();
		long diffTime = between(beforeTime, afterTime).toMillis();
		out.println("diffTime = " + diffTime);
		out.println("dfs = " + dfs);
	}

	private static int DFS(int n, int r) {
		if (dy[n][r] > 0) return dy[n][r];
		if (n == r || r == 0) {
			return 1;
		} else {
			return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
		}
	}
}
