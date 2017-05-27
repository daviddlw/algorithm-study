package com.david.algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.david.interview.ArraySolution;
import com.david.interview.Interview06to10Case;
import com.david.leetcode.ListNode;

/**
 * 程序员面试经典题库06-10
 * 
 * @author David.dai
 * 
 */
public class Interview06To10Test {

	/**
	 * 像素翻转
	 */
	@Test
	public void testTransformImage06() {
		int[][] testArr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] resultArr = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		int[][] newArr = Interview06to10Case.transformImage(testArr, 3);
		Assert.assertArrayEquals(resultArr, newArr);
	}

	/**
	 * 清除行列
	 */
	@Test
	public void testClearZero07() {
		int[][] testMat = new int[][] { { 1, 2, 3 }, { 0, 1, 2 }, { 0, 0, 1 } };
		int[][] resultMat = Interview06to10Case.clearZero(testMat, 3);
		int[][] checkMat = new int[][] { { 0, 0, 3 }, { 0, 0, 0 }, { 0, 0, 0 } };
		Assert.assertArrayEquals(checkMat, resultMat);
	}

	@Test
	public void testFindKthToTail() {
		ListNode head = getInitNode();
		ListNode node = Interview06to10Case.findKthToTail(head, 2);
		System.err.println(node);
	}

	private ListNode getInitNode() {
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		return head;
	}

	@Test
	public void testFindToTail() {
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode head = getInitNode();

		List<ListNode> resultList = findNodeToTail(head, list);
		System.out.println(resultList);
	}

	public List<ListNode> findNodeToTail(ListNode head, List<ListNode> list) {
		list.add(head);
		if (head.next != null) {
			return findNodeToTail(head.next, list);
		} else {
			return list;
		}
	}

	/**
	 * 双栈实现队列
	 */
	@Test
	public void testArraySolution() {
		ArraySolution solution = new ArraySolution();
		solution.push(1);
		solution.push(2);
		solution.push(3);
		System.out.println(solution.pop());
		System.out.println(solution.pop());
		solution.push(4);
		System.out.println(solution.pop());
		solution.push(5);
		System.out.println(solution.pop());
		System.out.println(solution.pop());
	}


}
