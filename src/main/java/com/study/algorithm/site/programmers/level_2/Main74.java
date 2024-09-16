package com.study.algorithm.site.programmers.level_2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Main74 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(
                        new int[]{180, 5000, 10, 600},
                        new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
                ))
        );
    }

    private static int[] solution(int[] fees, String[] records) {
        Map<String, LocalTime> checkInTimes = new HashMap<>();
        Map<String, Integer> totalParkingTimes = new HashMap<>();

        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 주차 기록 처리
        for (String record : records) {

            String[] details = record.split(" ");
            String time = details[0];
            String carNumber = details[1];
            String action = details[2];

            if (action.equals("IN")) {
                checkInTimes.put(carNumber, LocalTime.parse(time));
            } else if (action.equals("OUT")) {
                LocalTime inTime = checkInTimes.get(carNumber);
                LocalTime outTime = LocalTime.parse(time);
                int usedTime = (int) Duration.between(inTime, outTime).toMinutes();
                totalParkingTimes.put(carNumber, totalParkingTimes.getOrDefault(carNumber, 0) + usedTime);
                checkInTimes.remove(carNumber);
            }
        }

        for (Map.Entry<String, LocalTime> entry : checkInTimes.entrySet()) {
            int diff = (int) Duration.between(entry.getValue(), LocalTime.of(23, 59)).toMinutes();
            totalParkingTimes.put(entry.getKey(), totalParkingTimes.getOrDefault(entry.getKey(), 0) + diff);
        }

        List<Integer> list = new ArrayList<>();
        totalParkingTimes.entrySet().stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey())).forEach(x -> {
            if (x.getValue() <= defaultTime) {
                list.add(defaultFee);
            } else {
                list.add(defaultFee + ((x.getValue() - defaultTime + unitTime - 1) / unitTime) * unitFee);
            }
        });

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}