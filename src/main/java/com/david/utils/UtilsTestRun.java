package com.david.utils;

public class UtilsTestRun {
	public static void main(String[] args) {
		httpGet();
	}
	
	private static void httpGet() {
		String url = "http://www.baidu.com";
		String result = HttpUtils.httpGet(url);
		System.out.println(result);
	}
	
	private static void httpPostForm() {
		
	}
	
	private static void httpPostBody() {
		
	}
}
