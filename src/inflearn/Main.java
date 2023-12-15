package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = kb.nextInt();
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = kb.nextInt();
        ArrayList<Integer> solution = solution(n, m, arr1, arr2);
        System.out.println("solution = " + solution);
    }

    static ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) list.add(arr1[p1++]);
            else list.add(arr2[p2++]);
        }

        while (p1 < n) list.add(arr1[p1++]);
        while (p2 < m) list.add(arr2[p2++]);

        return list;
    }
}