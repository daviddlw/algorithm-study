package com.david.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * leetcode试题
 * 
 * @author dailiwei
 *
 */
public class LeetcodeProblem {
	public static void main(String[] args) {
		// System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 },
		// 18)));
		// System.out.println(fizzBuzz(15));
		// testListNode();
		// showPrimeNum(21);
		isPrimeV2(9);
	}

	private static void testListNode() {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;

		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		ListNode n6 = new ListNode(4);
		n4.next = n5;
		n5.next = n6;

		ListNode result = addTwoNumbers(n1, n4);
		System.out.println(result);
	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> indexValueMap = new HashMap<>();
		int value = 0;
		int[] resultArr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!indexValueMap.containsKey(nums[i])) {
				value = target - nums[i];
				indexValueMap.put(value, i);
			} else {
				resultArr[0] = indexValueMap.get(nums[i]);
				resultArr[1] = i;
			}
		}

		return resultArr;
	}

	private static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				list.add("FizzBuzz");
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(String.valueOf(i));
			}
		}
		return list;
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		List<Integer> l1List = new ArrayList<>();
		List<Integer> l2List = new ArrayList<>();
		do {
			if (l1 != null) {
				l1List.add(l1.val);
			}
			l1 = l1.next;
		} while (l1 != null);

		do {
			if (l2 != null) {
				l2List.add(l2.val);
			}
			l2 = l2.next;
		} while (l2 != null);

		List<Integer> longList;
		List<Integer> shortList;
		if (l1List.size() >= l2List.size()) {
			longList = l1List;
			shortList = l2List;
		} else {
			longList = l2List;
			shortList = l1List;
		}

		List<ListNode> list = new ArrayList<>();
		int value = 0;
		for (int i = 0; i < longList.size(); i++) {
			value = longList.get(i) + shortList.get(i);
			value = value >= 10 ? value % 10 : value;
			result.val = value;
			if (result.next == null) {
				ListNode nextNode = new ListNode(-1);
				result.next = nextNode;
			}
			result = result.next;
			list.add(result);
		}

		for (int i = shortList.size(); i < longList.size(); i++) {
			value = longList.get(i);
			value = value >= 10 ? value % 10 : value;
			result.val = value;
			if (result.next == null) {
				ListNode nextNode = new ListNode(-1);
				result.next = nextNode;
			}
			result = result.next;
			list.add(result);
		}

		list.add(new ListNode(-1));

		result = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			result.next = list.get(i);
			result = result.next;
		}

		return result;
	}

	private static boolean isPrime(int n) {
		int num = n;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static void showPrimeNum(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}

		System.out.println(list);
	}

	private static void isPrimeV2(int num) {
		boolean[] isPrime = new boolean[num];
		for (int i = 2; i < num; i++) {
			isPrime[i] = true;
		}
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < num; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < num; j += i) {
				isPrime[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < num; i++) {
			if (isPrime[i])
				count++;
		}
		System.out.println(count);
	}
}
