package com.study.algorithm.site.leetCode;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
//		System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
//		System.out.println(Arrays.toString(plusOne(new int[]{9})));
		System.out.println(Arrays.toString(plusOne(
			new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7,
				4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6})));
	}

	private static int[] plusOne(int[] digits) {
		StringBuilder sb = new StringBuilder();
		for (int digit : digits) {
			sb.append(digit);
		}

		BigInteger bigInt = new BigInteger(sb.toString());
		String result = String.valueOf(bigInt.add(BigInteger.ONE));
		return Arrays.stream(result.split("")).mapToInt(Integer::parseInt).toArray();
	}
}
