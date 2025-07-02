package com.study.algorithm.site.programmers.level_2;

import java.util.Arrays;
import java.util.Collections;

public class Main101 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{5, 3, 2},
			new String[][]{
				{"A", "A", "-1", "B", "B", "B", "B", "-1"},
				{"A", "A", "-1", "B", "B", "B", "B", "-1"},
				{"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
				{"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
				{"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
				{"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
		}));
	}

	private static int solution(int[] mats, String[][] park) {
		int answer = -1;

		// mats 배열을 내림차순으로 정렬
		mats = Arrays.stream(mats)
			.boxed()
			.sorted(Collections.reverseOrder())
			.mapToInt(Integer::intValue)
			.toArray();

		for (int mat : mats) {
			// 전체 길이에서 돗자리 크기를 뺌
			for (int row = 0; row <= park.length - mat; row++) {
				for (int col = 0; col <= park[0].length - mat; col++) {
					boolean chk = true;

					// 돗자리를 놓을 수 있는지 확인
					if (park[row][col].equals("-1") && row + mat <= park.length && col + mat <= park[0].length) {
						// 해당 범위에 돗자리를 설치할 수 있는지 탐색
						for (int k = 0; k < mat; k++) {
							for (int l = 0; l < mat; l++) {

								// 사람이 있으면 돗자리 설치 불가
								if (!park[row + k][col + l].equals("-1")) {
									chk = false;
									break;
								}
							}
							// 중간에 사람이 있으면 루프 중단
							if (!chk) break;
						}

						// 설치 가능할 경우 바로 답을 반환
						if (chk) return mat;
					}
				}
			}
		}

		return answer;
	}
}
