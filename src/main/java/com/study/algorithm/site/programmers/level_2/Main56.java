package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main56 {

	public static void main(String[] args) {
		String[] answer = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
		System.out.println(Arrays.toString(answer));
	}

	private static String[] solution(String[] record) {
		Queue<User> Q = new LinkedList<>();
		Map<String, String> map = new HashMap<>();
		for (String r : record) {
			String[] s = r.split(" ");

			if (s[0].equals("Enter")) {
				Q.offer(new User(s[0], s[1]));
			} else if (s[0].equals("Leave")) {
				Q.offer(new User(s[0], s[1]));
				continue;
			} else if (s[0].equals("Change")) {
				map.put(s[1], s[2]);
			}

			map.put(s[1], s[2]);
		}
		Map<String, String> msg = new HashMap<>();
		msg.put("Enter", "님이 들어왔습니다.");
		msg.put("Leave", "님이 나갔습니다.");

		List<String> answer = new ArrayList<>();
		while (!Q.isEmpty()) {
			User user = Q.poll();
			String m = msg.get(user.action);
			answer.add(map.get(user.uuid) + m);
		}

		return answer.stream().toArray(String[]::new);
	}

	private static class User {
		public String action;
		public String uuid;

		public User(String action, String uuid) {
			this.action = action;
			this.uuid = uuid;
		}
	}
}