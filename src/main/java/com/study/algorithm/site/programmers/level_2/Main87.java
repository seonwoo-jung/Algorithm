package com.study.algorithm.site.programmers.level_2;

import java.time.LocalTime;
import java.util.*;

public class Main87 {

	public static void main(String[] args) {
		System.out.println(solution2(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
		System.out.println(solution2(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
		System.out.println(solution2(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
	}

	private static int solution2(String[][] book_time) {
		int answer = 0;
		Arrays.sort(book_time, Comparator.comparing(x -> x[0]));
		Queue<int[]> PQ = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

		for (String[] book : book_time) {
			String[] starts = book[0].split(":");
			String[] ends = book[1].split(":");
			int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
			int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 10;

			if (PQ.isEmpty()) {
				answer++;
				PQ.offer(new int[]{start, end});
				continue;
			}

			int[] prev = PQ.poll();
			int prevStart = prev[0];
			int prevEnd = prev[1];
			if (start >= prevEnd) {
				PQ.offer(new int[]{start, end});
			} else {
				answer++;
				PQ.offer(new int[]{start, end});
				PQ.offer(prev);
			}
		}

		return answer;
	}

	private static int solution(String[][] book_time) {
		LocalTime[][] bookTime = new LocalTime[book_time.length][2];

		for (int i = 0; i < book_time.length; i++) {
			LocalTime start = LocalTime.parse(book_time[i][0]);
			LocalTime end = LocalTime.parse(book_time[i][1]).plusMinutes(10);

			bookTime[i][0] = start;
			bookTime[i][1] = end;
		}

		Arrays.sort(bookTime, Comparator.comparing(o -> o[0]));

		Queue<LocalTime[]> PQ = new PriorityQueue<>(Comparator.comparing(o -> o[1]));

		for (LocalTime[] book : bookTime) {
			if (!PQ.isEmpty() && !PQ.peek()[1].isAfter(book[0])) {
				PQ.poll();
			}
			PQ.add(book);
		}

		return PQ.size();
	}
}