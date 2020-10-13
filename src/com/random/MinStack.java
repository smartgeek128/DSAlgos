package com.random;

import java.util.Stack;

public class MinStack {
	private int min;
	private Stack<Integer> stack;

	/** initialize your data structure here. */
	public MinStack() {
		min = Integer.MAX_VALUE;
		stack = new Stack<>();
	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   // --> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      // --> Returns 0.
		System.out.println(minStack.getMin());   // --> Returns -2.
	}
}