package com.david.algorithm_study;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(12876561));
		System.out.println(12876561 % 10);
	}

	public static int reverse2(int x) {
		List<Integer> list = new ArrayList<>();
		int result = 0;
		do {
			result = x % 10;
			x /= 10;
			list.add(result);
		} while (x > 0);
		return 0;
	}

	public static int reverse(int x) {
		String s = String.valueOf(x);
		char[] charArr = s.toCharArray();
		boolean isNegative = false;
		// 检查是否有符号位
		if (charArr.length > 0) {
			char c = charArr[0];
			if (c == '-') {
				isNegative = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		if (isNegative) {
			sb.append(charArr[0]); // 首先添加符号
			for (int i = charArr.length - 1; i > 0; i--) {
				sb.append(charArr[i]);
			}
		} else {
			for (int i = charArr.length - 1; i >= 0; i--) {
				sb.append(charArr[i]);
			}
		}

		Integer i = 0;
		try {
			i = Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			Long li = Long.parseLong(sb.toString());
			i = li.intValue();
		}

		return i;
	}
}
