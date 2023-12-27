package other.study.stream;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class IteratorVsStreamExample {
    public static void main(String[] args) {
        List<String> list = asList("홍길동", "신용권", "감자바");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        System.out.println();

        // Stream 이용
        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println(name));
    }
}
