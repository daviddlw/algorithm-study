package com.david.leetcode;

import java.util.LinkedList;

public class NumCount implements Comparable<NumCount> {
	private int value;
	private int count;

	public NumCount() {
		super();
	}

	public NumCount(int value, int count) {
		super();
		this.value = value;
		this.count = count;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "NumCount [value=" + value + ", count=" + count + "]";
	}

	@Override
	public int compareTo(NumCount o) {
		if (o.getCount() > getCount()) {
			return 1;
		} else if (o.getCount() < getCount()) {
			return -1;
		} else {
			return 0;
		}
	}
}
