package other.dp;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class DP3 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        ArrayList<Person> list = new ArrayList<>();
    }


    static class Person implements Comparable<Person> {
        private int s, e;

        public Person(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Person o) {
            return this.s - o.s;
        }
    }
}
