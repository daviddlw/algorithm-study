package com.david.interview;

import java.util.Stack;

public class Interview11to15Case {

	public static void octalNumber(int num) {
		if (num < 0 || num > 100000) {
			throw new IllegalArgumentException("num必须在0~100000之间");
		}

		int result = num;
		int divNum = 0;
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			divNum = result / 8;
			
		}
	}
}
