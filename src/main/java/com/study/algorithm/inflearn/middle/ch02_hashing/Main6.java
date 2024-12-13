package com.study.algorithm.inflearn.middle.ch02_hashing;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 문서도난
 */
public class Main6 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}

	private static String[] solution(String[] reports, String times) {
		List<String> answer = new ArrayList<>();

		Arrays.sort(reports, ((o1, o2) -> {
			String a = o1.split(" ")[1];
			String b = o2.split(" ")[1];
			return LocalTime.parse(a).compareTo(LocalTime.parse(b));
		}));

		String[] t = times.split(" ");
		LocalTime st = LocalTime.parse(t[0]);
		LocalTime et = LocalTime.parse(t[1]);

		for (String x : reports) {
			String name = x.split(" ")[0];
			String usedTime = x.split(" ")[1];
			LocalTime used = LocalTime.parse(usedTime);
			if (!used.isBefore(st) && !used.isAfter(et)) {
				answer.add(name);
			}
		}

		return answer.stream()
			.map(String::valueOf)
			.toArray(String[]::new);
	}

	private static String[] solution2(String[] reports, String times) {
		List<Info> tmp = new ArrayList<>();

		for (String x : reports) {
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			tmp.add(new Info(a, getTime(b)));
		}

		Collections.sort(tmp);

		int s = getTime(times.split(" ")[0]);
		int e = getTime(times.split(" ")[1]);

		List<String> res = new ArrayList<>();

		for (Info ob : tmp) {
			if (ob.time >= s && ob.time <= e) {
				res.add(ob.name);
			}
			if (ob.time > e) {
				break;
			}
		}
		String[] answer = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}

		return answer;
	}

	private static int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);

		return H * 60 + M;
	}

	private static class Info implements Comparable<Info> {

		public String name;
		public int time;

		public Info(String name, int time) {
			this.name = name;
			this.time = time;
		}

		@Override
		public int compareTo(Info ob) {
			return this.time - ob.time;
		}
	}
}
