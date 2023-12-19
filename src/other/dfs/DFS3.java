package other.dfs;

import java.util.Scanner;

import static java.lang.Math.min;
import static java.lang.System.in;

public class DFS3 {

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        Scanner kb = new Scanner(in);
        int n = kb.nextInt();
        int m = kb.nextInt();

    }


    static int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }

    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
}
