package DataStructure;

import java.util.Stack;

public class StackImpl {
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		// 0, 1, 2, 3, 4
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}

		System.out.println("stack = " + stack);

		stack.pop();
		stack.pop();

		stack.push(5);

		System.out.println("stack = " + stack);

		System.out.println("stack.peek() = " + stack.peek());
	}
}
