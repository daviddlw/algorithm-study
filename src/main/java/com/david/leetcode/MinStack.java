package com.david.leetcode;

import java.util.LinkedList;

public class MinStack {
	private LinkedList<Integer> list = new LinkedList<>();
	private int min = Integer.MAX_VALUE;

	public void push(int x) {
		if (x <= min) {
			list.push(x);
			min = x;
		}
		list.push(x);
	}

	public void pop() {
		if (!list.isEmpty()) {
			if (list.pop() == min) {
				min = list.pop();
			}
		}
	}

	public int top() {
		return list.isEmpty() ? 0 : list.peek();
	}

	public int getMin() {
		return min;
	}
}
