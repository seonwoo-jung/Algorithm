package algorithm.ch04;

import algorithm.ch04.IntStack.EmptyIntStackException;
import algorithm.ch04.IntStack.OverflowIntStackException;

import java.util.Scanner;

import static java.lang.System.*;

public class IntStackTester {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(in);
        IntStack s = new IntStack(64);

        while (true) {

            out.println();
            out.printf("현재 데이터 개수: %d / %d \n", s.size(), s.getCapacity());
            out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료: ");

            int menu = stdIn.nextInt();

            if (menu == 0) {
                break;
            }

            int x;

            switch (menu) {
                case 1:
                    out.print("데이터: ");
                    x = stdIn.nextInt();

                    try {
                        s.push(x);
                    } catch (OverflowIntStackException e) {
                        out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (EmptyIntStackException e) {
                        out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (EmptyIntStackException e) {
                        out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
