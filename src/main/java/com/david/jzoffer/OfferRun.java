package com.david.jzoffer;

import java.util.ArrayList;
import java.util.List;

public class OfferRun {
	public static void main(String[] args) {
		testFindInDimension2Array();
	}

	public static void testFindInDimension2Array() {
		// int[][] array = new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4,
		// 7, 10, 13 }, { 6, 8, 11, 15 } };
		int[][] array = new int[][] { {} };
		int target = 16;
		System.out.println(findInDimension2Array(target, array));
	}

	public static boolean findInDimension2Array2(int target, int[][] array) {
		int len = array.length - 1;
		if (array.length <= 0) {
			return false;
		} else if (array[array.length - 1].length <= 0) {
			return false;
		}
		int i = 0; // 控制列
		// 判断行列，从左下角开始，因为左上角开始都是自增无法判断有岔路，左下角开始找，大于目标值往右找，小与目标值往上找
		while (len >= 0 && i < array.length) {
			if (array[len][i] < target) {
				i++; // 往右列找
			} else if (array[len][i] > target) {
				len--;
			} else {
				return true;
			}
		}

		return false;
	}

	public static boolean findInDimension2Array(int target, int[][] array) {
		List<Integer> rowIndex = new ArrayList<>();
		List<Integer> colIndex = new ArrayList<>();

		for (int i = 0; i < array[0].length; i++) {
			if (array[0][i] == target) {
				return true;
			} else if (array[0][i] > target) {
				continue;
			} else {
				colIndex.add(i);
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i][0] == target) {
				return true;
			} else if (array[i][0] > target) {
				continue;
			} else {
				rowIndex.add(i);
			}
		}

		for (Integer row : rowIndex) {
			for (Integer col : colIndex) {
				if (array[row][col] == target) {
					return true;
				}
			}
		}

		return false;
	}

}
