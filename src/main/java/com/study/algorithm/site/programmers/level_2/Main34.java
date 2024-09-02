package com.study.algorithm.site.programmers.level_2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main34 {

	private static final Integer MULTIPLIER = Character.MAX_VALUE + 1;

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}

	private static int solution(String str1, String str2) {
		String word1 = str1.toLowerCase();
		String word2 = str2.toLowerCase();

		Map<String, Long> words1 = group(word1);
		Map<String, Long> words2 = group(word2);

		Integer intersection = getIntersection(words1, words2);
		Integer union = getUnion(words1, words2);

		if (intersection.equals(union) && union.equals(0)) {
			return MULTIPLIER;
		}

		return (int) (intersection.doubleValue() / union.doubleValue() * MULTIPLIER);
	}

	private static Map<String, Long> group(String word) {
		return IntStream.range(0, word.length() - 1)
			.mapToObj(index -> word.substring(index, index + 2))
			.filter(text -> text.chars().allMatch(character -> Character.isAlphabetic((char) character)))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	private static Integer getIntersection(Map<String, Long> words1, Map<String, Long> words2) {
		return words1.entrySet().stream()
			.filter(entry -> words2.containsKey(entry.getKey()))
			.map(entry -> Math.min(entry.getValue(), words2.get(entry.getKey())))
			.mapToInt(Long::intValue)
			.sum();
	}

	private static Integer getUnion(Map<String, Long> words1, Map<String, Long> words2) {
		Map<String, Long> copiedWords = new HashMap<>(words2);
		words1.forEach((key, value) -> copiedWords.put(key, Math.max(value, words2.getOrDefault(key, 0L))));
		return copiedWords.values().stream()
			.mapToInt(Long::intValue)
			.sum();
	}
}