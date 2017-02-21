package com.david.algorithm_study;

import org.junit.Assert;
import org.junit.Test;

import com.david.interview.Interview01to05Case;

/**
 * 程序员面试经典题库01-05
 * 
 * @author David.dai
 * 
 */
public class Interview01To05Test {

	/**
	 * 确定字符串互异
	 */
	@Test
	public void testCheckDifferent01() {
		String s1 = "aeiou";
		String s2 = "BarackObama";
		boolean b1 = Interview01to05Case.checkDifferent(s1);
		System.out.println("b1: " + b1);
		boolean b2 = Interview01to05Case.checkDifferent(s2);
		System.out.println("b2: " + b2);

		Assert.assertEquals(b1, true);
		Assert.assertEquals(b2, false);
	}

	/**
	 * 原串翻转
	 */
	@Test
	public void testReverseString02() {
		String s = "This is nowcoder";
		String result = Interview01to05Case.reverseString(s);
		System.out.println("reverse str: " + result);
		Assert.assertEquals("redocwon si sihT", result);
	}

	/**
	 * 确定两串乱序同构
	 */
	@Test
	public void testCheckSame03() {
		String s1 = "This is nowcoder";
		String s2 = "is This nowcoder";
		boolean same1 = Interview01to05Case.checkSame(s1, s2);
		System.out.println(same1);
		Assert.assertEquals(same1, true);

		String s3 = "Here you are";
		String s4 = "Are you here";
		boolean same2 = Interview01to05Case.checkSame(s3, s4);
		System.out.println(same2);
		Assert.assertEquals(same2, false);
	}


	/**
	 * 空格替换
	 */
	@Test
	public void testReplaceSpace04() {
		String s1 = "Mr John Smith";
		String nS1 = Interview01to05Case.replaceSpace(s1, s1.length());
		System.out.println(nS1);
		Assert.assertEquals(nS1, "Mr%20John%20Smith");

		String s2 = "Hello  World";
		String nS2 = Interview01to05Case.replaceSpace(s2, s2.length());
		System.out.println(nS2);
		Assert.assertEquals(nS2, "Hello%20%20World");
	}

	/**
	 * 基本压缩字符串
	 */
	@Test
	public void testZipString05() {
		String str1 = "aabcccccaaa";
		String str2 = "qwertyuioplkjhgfdsAzxcvbNM";

		String result1 = Interview01to05Case.zipString(str1);
		System.out.println("zip str1: " + result1);
		Assert.assertEquals("a2b1c5a3", result1);

		String result2 = Interview01to05Case.zipString(str2);
		System.out.println("zip str2: " + result2);
		Assert.assertEquals("qwertyuioplkjhgfdsAzxcvbNM", result2);
	}

}
