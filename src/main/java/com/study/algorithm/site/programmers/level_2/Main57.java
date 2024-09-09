package com.study.algorithm.site.programmers.level_2;

import java.util.*;

public class Main57 {

	public static void main(String[] args) {
		int[] solution = solution(
			new String[]{"classic", "pop", "classic", "classic", "pop"},
			new int[]{500, 600, 150, 800, 2500}
		);

		System.out.println(Arrays.toString(solution));
	}

	private static int[] solution(String[] genres, int[] plays) {
		Map<String, ArrayList<Music>> playMap = new HashMap<>();
		Map<String, Integer> genresMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (playMap.containsKey(genres[i])) {
				genresMap.put(genres[i], genresMap.get(genres[i]) + plays[i]);
				ArrayList<Music> music = playMap.get(genres[i]);
				music.add(new Music(i, plays[i]));
			} else {
				genresMap.put(genres[i], plays[i]);
				playMap.put(genres[i], create(i, plays[i]));
			}
		}

		String[] orderdGenres = genresMap.entrySet().stream()
			.sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())).map(HashMap.Entry::getKey)
			.toArray(String[]::new);

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < orderdGenres.length; i++) {
			for (int j = 0; j < 2; j++) {
				ArrayList<Music> music = playMap.get(orderdGenres[i]);
				Collections.sort(music);
				if (music.size() < 2) {
					answer.add(music.get(j).idx);
					break;
				} else {
					answer.add(music.get(j).idx);
				}
			}
		}
		System.out.println("genresMap = " + genresMap);
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static ArrayList<Music> create(int idx, int play) {
		ArrayList<Music> music = new ArrayList<>();
		music.add(new Music(idx, play));
		return music;
	}

	private static class Music implements Comparable<Music> {
		public int idx;
		public int plays;

		public Music(int idx, int plays) {
			this.idx = idx;
			this.plays = plays;
		}

		@Override
		public int compareTo(Music o) {
			if (this.plays == o.plays) {
				return this.idx - o.idx;
			} else {
				return o.plays - this.plays;
			}
		}

		@Override
		public String toString() {
			return "Music{" +
				"idx=" + idx +
				", plays=" + plays +
				'}';
		}
	}
}