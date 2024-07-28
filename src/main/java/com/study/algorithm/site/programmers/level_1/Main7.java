package com.study.algorithm.site.programmers.level_1;

import java.util.ArrayList;
import java.util.List;

public class Main7 {

	public static void main(String[] args) {
		int x = 4, n = 3;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(x * i);
		}
		Long[] array = list.stream().toArray(Long[]::new);

	}

	static class Data implements Comparable<Data> {

		private int code, date, maximum, remain;

		public Data(int code, int date, int maximum, int remain) {
			this.code = code;
			this.date = date;
			this.maximum = maximum;
			this.remain = remain;
		}

		@Override
		public int compareTo(Data o) {

			return 0;
		}
	}
}
