package com.david.algorithm_study;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author dailiwei
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// sortArray(new int[] { 2, 7, 11, 152 });
		int[] resultArr = twoSum(new int[] { 2, 7, 11, 15 }, 13);
		System.out.println(Arrays.toString(resultArr));
	}

	private static int[] twoSum(int[] numbers, int target) {
		int n = numbers.length;
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		return result;
	}

	private static void sortArray(int[] arr) {
		System.out.println("before = " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("after = " + Arrays.toString(arr));
	}
}
