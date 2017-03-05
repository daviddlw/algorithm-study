package com.david.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class UtilsTestRun {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// httpGet();
		// httpGetForParams();
		// httpPostForm();
		httpPostBody();
	}

	private static void httpGet() {
		String url = "http://www.baidu.com";
		String result = HttpUtils.httpGet(url);
		System.out.println(result);
	}

	private static void httpGetForParams() {
		String url = "http://localhost:8080/algorithm-study/utils/http_get_query.json";
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("id", "1");
		queryMap.put("name", "daviddai");
		String result = HttpUtils.httpGet(url, queryMap);
		System.out.println(result);
	}

	private static void httpPostForm() throws UnsupportedEncodingException {
		String url = "http://localhost:8080/algorithm-study/utils/http_post_form.json";
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("id", "1");
		queryMap.put("name", "daviddai");
		String result = HttpUtils.httpPostForm(url, queryMap);
		System.out.println(result);
	}

	private static void httpPostBody() throws UnsupportedEncodingException {
		String url = "http://localhost:8080/algorithm-study/utils/http_post_body.json";
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("id", "1");
		queryMap.put("name", "daviddai");
		String result = HttpUtils.httpPost(url, JSON.toJSONString(queryMap));
		System.out.println(result);
	}
}
