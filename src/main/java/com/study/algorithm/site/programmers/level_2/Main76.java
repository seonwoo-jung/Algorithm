package com.study.algorithm.site.programmers.level_2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main76 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
    }

    private static String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("^([A-Za-z .-]+)(\\d+)(.*)$");
        List<File> list = new ArrayList<>();
        for (String file : files) {
            Matcher matcher = pattern.matcher(file);
            if (matcher.find()) {
                list.add(new File(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        list.sort(null);
        return list.stream().map(File::toString).toArray(String[]::new);
    }

    private static class File implements Comparable<File> {
        String head;
        String number;
        String extension;

        public File(String head, String number, String extension) {
            this.head = head;
            this.number = number;
            this.extension = extension;
        }

        @Override
        public String toString() {
            return head + number + extension;
        }

        @Override
        public int compareTo(File o) {
            int head = this.head.compareToIgnoreCase(o.head);
            if (head != 0) {
                return head;
            }

            return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
        }
    }
}