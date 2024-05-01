package com.study.algorithm.other.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {
	public static void main(String[] args) {
		try {
			// 요청을 보낼 URL 설정
			URL url = new URL("https://www.naver.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// 요청 헤더 출력
			System.out.println("Request Headers:");
			connection.getRequestProperties().forEach((key, value) ->
					System.out.println(key + ": " + value));

			int responseCode = connection.getResponseCode();
			System.out.println("\nResponse Code: " + responseCode);

			// 응답 본문 출력
			System.out.println("\nResponse Body:");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			System.out.println(response.toString());

			// 연결 닫기
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
