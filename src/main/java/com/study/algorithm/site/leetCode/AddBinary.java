package com.study.algorithm.site.leetCode;

import java.math.BigInteger;

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(addBinary("1010", "1011"));
	}

	private static String addBinary(String a, String b) {
		BigInteger decimalA = new BigInteger(a, 2);
		BigInteger decimalB = new BigInteger(b, 2);
		return decimalA.add(decimalB).toString(2);
	}
}
