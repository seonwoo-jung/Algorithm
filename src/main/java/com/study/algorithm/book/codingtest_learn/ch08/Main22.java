package com.study.algorithm.book.codingtest_learn.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Main22 {

	public static void main(String[] args) {
		int[] solution = solution(
			new String[]{"classic", "pop", "classic", "classic", "pop"},
			new int[]{500, 600, 150, 800, 2500}
		);

		System.out.println(Arrays.toString(solution));
	}

	private static int[] solution(String[] genres, int[] plays) {
		HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
		HashMap<String, Integer> playMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];

			if (!genreMap.containsKey(genre)) {
				genreMap.put(genre, new ArrayList<>());
				playMap.put(genre, 0);
			}
			genreMap.get(genre).add(new int[]{i, play});
			playMap.put(genre, playMap.get(genre) + play);
		}

		ArrayList<Integer> answer = new ArrayList<>();

		Stream<Entry<String, Integer>> sortedGenre = playMap.entrySet().stream()
			.sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

		sortedGenre.forEach(entry -> {
			Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
				.sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
				.limit(2);
			sortedSongs.forEach(song -> answer.add(song[0]));
		});

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
