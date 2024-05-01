package algorithm.ch06;

import java.util.Scanner;

import static java.lang.System.in;

public class BubbleSort2 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(in);

        System.out.println("버블 정렬(버전 2)");
        System.out.print("요솟수: ");
        
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            // 패스에서 교환하는 횟수를 저장
            int exchg = 0;

            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
                // 교환이 이루어지지 않으므로 멈춤
                if (exchg == 0) break;
            }
        }
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}
