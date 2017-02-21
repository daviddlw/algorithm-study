package com.david.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview06to10Case {

	public static int[][] transformImage(int[][] mat, int n) {
		// n行n列移动n-1步
		List<List<Integer>> list = new ArrayList<List<Integer>>(n);

		for (int i = 0; i < mat.length; i++) {
			List<Integer> innerList = new ArrayList<Integer>();
			for (int j = mat[i].length - 1; j >= 0; j--) {
				innerList.add(mat[j][i]);
			}
			list.add(innerList);
		}

		System.out.println(list);
		int[][] newArr = new int[n][n];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				newArr[i][j] = list.get(i).get(j);
			}
		}

		return newArr;
	}

	// Some bugs has already exist, cannot use the map to record the position
	public static int[][] clearZero(int[][] mat, int n) {
		if (n > 300) {
			throw new IllegalArgumentException("Illegal argument for number " + n);
		}

		int[][] resultMat = new int[n][n];
		Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					if (!targetMap.containsKey(mat[i][j])) {
						targetMap.put(i, j);
					}
				}

				resultMat[i][j] = mat[i][j];
			}
		}

		// 执行清理操作
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				// 当前行中包含0，执行清零操作
				if (targetMap.keySet().contains(i)) {
					resultMat[i][j] = 0;
				}

				// 当前列中包含0，执行清零操作
				if (targetMap.values().contains(j)) {
					resultMat[i][j] = 0;
				}
			}
		}

		showMat(resultMat);
		return resultMat;
	}

	private static void showMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	public static ListNode findKthToTail(ListNode head, int k) {
		if (head.next == null || k < 0) {
			return null;
		}

		int count = 0;
		ListNode pre = head;
		ListNode last = head;
		for (int i = 0; i < k; i++) {
			if (pre.next != null) {
				pre = pre.next;
				count++; // 记录节点个数
			} else {
				return null;
			}
		}

		while (pre.next != null) {
			pre = pre.next;
			last = last.next;
			count++;
		}

		if (count < k) {
			return null;
		}

		return last;
	}
	
}
