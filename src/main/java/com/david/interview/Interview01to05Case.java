package com.david.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview01to05Case {
	
	public static boolean checkDifferent(String iniString) {
		if (iniString.length() > 3000) {
			throw new IllegalArgumentException("iniString length must be less than 3000");
		}

		List<Character> list = new ArrayList<Character>(iniString.length());
		char[] arr = iniString.toCharArray();
		for (char c : arr) {
			if (list.contains(c)) {
				return false;
			}

			list.add(c);
		}

		return true;
	}
	
	public static String reverseString(String iniString) {
		if (iniString.length() > 5000) {
			throw new IllegalArgumentException("iniString length must be less than 5000");
		}

		StringBuilder sb = new StringBuilder();
		char[] arr = iniString.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		String str = sb.toString();
		return str;
	}
	
	public static boolean checkSame(String stringA, String stringB) {
		if (stringA.length() > 5000) {
			throw new IllegalArgumentException("stringA length must be less than 5000");
		}

		if (stringB.length() > 5000) {
			throw new IllegalArgumentException("stringB length must be less than 5000");
		}
		char[] cA = stringA.toCharArray();
		char[] cB = stringB.toCharArray();
		Arrays.sort(cA);
		Arrays.sort(cB);
		return Arrays.equals(cA, cB);
	}
	
	public static String replaceSpace(String iniString, int length) {
		if (iniString.length() > 1000) {
			throw new IllegalArgumentException("iniString length must be less than 1000");
		}

		String s = iniString.replaceAll("\\s{1}", "%20");
		return s;
	}
	
	public static String zipString(String iniString) {
		if (iniString.length() > 10000) {
			throw new IllegalArgumentException("iniString length must be less than 10000");
		}

		StringBuilder sb = new StringBuilder();
		char[] arr = iniString.toCharArray();
		int count = 0; // 记录字符个数
		char c = ' '; // 记录初始字符
		int searchIndex = 0; // 搜寻索引值
		int i;
		while (searchIndex < arr.length) {
			c = arr[searchIndex];
			count++;

			do {
				i = searchIndex + 1;
				searchIndex = i;
				if (i < arr.length && arr[i] == c) {
					count++;
				} else if (i < arr.length) {
					sb.append(c);
					sb.append(count);
					// System.out.println("current str: " + sb.toString());
					break;
				}
				i++;
			} while (i < arr.length);

			if (i >= arr.length) {
				sb.append(c);
				sb.append(count);
				searchIndex = arr.length;
				// System.out.println("current str: " + sb.toString());
			}

			count = 0; // 字符个数统计清零
		}

		String result = sb.toString();
		return result.length() >= iniString.length() ? iniString : result;
	}
}
