package com.study.algorithm.site.programmers.level_1;

import java.util.HashMap;

public class Main1 {
	public static void main(String[] args) {
		solution2(
				new String[]{"mumu", "soe", "poe", "kai", "mine"},
				new String[]{"kai", "kai", "mine", "mine"}
		);
	}

	static String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];

		HashMap<String, Integer> mappedByPlayer = new HashMap<>();
		HashMap<Integer, String> mappedByRank = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			mappedByPlayer.put(players[i], i);
			mappedByRank.put(i, players[i]);
		}

		for (int i = 0; i < callings.length; i++) {
			// 플레이어의 등수를 가져옴
			int currentRank = mappedByPlayer.get(callings[i]);
			// 등수에 해당하는 플레이어를 가져옴
			String player = mappedByRank.get(currentRank);

			// 현재 등수 앞에 플레이어를 가져옴
			String frontPlayer = mappedByRank.get(currentRank - 1);

			// 플레이어의 등수를 앞으로 보냄
			mappedByPlayer.put(player, currentRank - 1);

			// 현재 등수 앞에 플레이어를 뒤로 보냄
			mappedByPlayer.put(frontPlayer, currentRank);

			mappedByRank.put(currentRank - 1, player);
			mappedByRank.put(currentRank, frontPlayer);
		}

		for (int i = 0; i < players.length; i++) {
			answer[i] = mappedByRank.get(i);
		}

		return answer;
	}

	static String[] solution2(String[] players, String[] callings) {
		int n = players.length;
		HashMap<String, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			indexMap.put(players[i], i);
		}

		for (String calling : callings) {
			int idx = indexMap.get(calling);
			if (idx > 0) {
				String temp = players[idx - 1];
				players[idx - 1] = players[idx];
				players[idx] = temp;

				indexMap.put(players[idx - 1], idx - 1);
				indexMap.put(players[idx], idx);
			}
		}

		return players;
	}
}
