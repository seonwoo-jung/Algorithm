package com.study.algorithm.book.doit_intro.ch04;

import java.util.Scanner;

import static java.lang.System.in;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(in);
		IntQueue s = new IntQueue(64);

		while (true) {
			System.out.println();
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (0) 종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0) {
				break;
			}

			int x;

			switch (menu) {

				// 인큐
				case 1:
					System.out.print("데이터: ");
					x = stdIn.nextInt();
					try {
						s.enque(x);
					} catch (IntQueue.OverflowIntQueueException e) {
						System.out.println("큐가 가득 찼습니다.");
					}
					break;

				// 디큐
				case 2:
					try {
						x = s.deque();
						System.out.println("디큐한 데이터는 " + x + "입니다.");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어 있습니다.");
					}
					break;

				// 피크
				case 3:
					try {
						x = s.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어 있습니다.");
					}
					break;

				// 덤프
				case 4:
					s.dump();
					break;
			}
		}
	}
}
