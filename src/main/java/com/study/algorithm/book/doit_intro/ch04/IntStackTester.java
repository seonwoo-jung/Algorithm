package com.study.algorithm.book.doit_intro.ch04;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class IntStackTester {
	public static void main(String[] args) {

		Scanner stdIn = new Scanner(in);
		IntStack s = new IntStack(64);

		while (true) {

			out.println();
			out.printf("현재 데이터 개수: %d / %d \n", s.size(), s.getCapacity());
			out.print("(1) 푸시 \n" +
					"(2) 팝 \n" +
					"(3) 피크 \n" +
					"(4) 덤프 \n" +
					"(5) 스택 사이즈 확인 \n" +
					"(6) 스택 비어있는지 확인 \n" +
					"(7) 스택 비우기 \n" +
					"(8) 값 조회 \n" +
					"(9) 가득 찼는지 조회 \n" +
					"(0) 종료: \n");

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
					} catch (IntStack.OverflowIntStackException e) {
						out.println("스택이 가득 찼습니다.");
					}
					break;

				case 2:
					try {
						x = s.pop();
						out.println("팝한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						out.println("스택이 비어 있습니다.");
					}
					break;

				case 3:
					try {
						x = s.peek();
						out.println("피크한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						out.println("스택이 비어 있습니다.");
					}
					break;

				case 4:
					s.dump();
					break;

				case 5:
					x = s.size();
					out.println("스택의 사이즈는 " + x + "입니다.");
					break;

				case 6:
					if (s.isEmpty()) {
						out.println("현재 스택은 비어 있습니다.");
					} else {
						out.println("현재 스택은 비어있지 않습니다.");
					}
					break;

				case 7:
					s.clear();
					out.println("현재 스택을 모두 비었습니다.");
					break;

				case 8:
					out.println("찾으려는 값을 입력해 주세요.");
					x = stdIn.nextInt();
					s.indexOf(x);
					break;

				case 9:
					if (s.isFull()) {
						out.println("현재 스택은 가득찼습니다.");
					} else {
						out.println("현재 스택은 가득차지 않았습니다.");
					}
					break;
			}
		}
	}
}
