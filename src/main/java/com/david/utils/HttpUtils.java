package com.david.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtils {

	private static final Logger log = Logger.getLogger(HttpUtils.class);

	private static final int DEFAULT_TIME_OUT = 15000;

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String DEFAULT_ENCODING = "utf-8";

	private volatile static CloseableHttpClient httpClient = null;

	private static final Object syncObj = new Object();

	/**
	 * 获取httpclient实例
	 * 
	 * @return httpclient实例
	 */
	public static CloseableHttpClient getHttpClient() {
		if (httpClient == null) {
			synchronized (syncObj) {
				if (httpClient == null) {
					// PoolingHttpClientConnectionManager创建的httpclient可以接受多线程操作
					PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
					// setMaxTotal设置最大连接数
					cm.setMaxTotal(200);
					// 设置每个路由的基础连接数
					cm.setDefaultMaxPerRoute(20);
					httpClient = HttpClients.custom().setConnectionManager(cm).build();
				}
			}
		}

		return httpClient;
	}

	/**
	 * 获取query查询参数
	 * 
	 * @param paramMap
	 *            查询参数map
	 * @param charset
	 *            编码格式
	 * @return 对应的query string
	 */
	public static String buildQueryString(Map<String, String> paramMap, String charset) {
		List<NameValuePair> list = toNameValuePairs(paramMap);
		if (list == null || list.size() == 0) {
			return null;
		}

		return URLEncodedUtils.format(list, charset);
	}

	/**
	 * 获取键值对列表
	 * 
	 * @param paramMap
	 *            参数映射map
	 * @return 参数化列表
	 */
	public static List<NameValuePair> toNameValuePairs(Map<String, String> paramMap) {
		if (paramMap == null || paramMap.isEmpty()) {
			return null;
		}
		List<NameValuePair> list = new ArrayList<>(paramMap.size());
		for (Entry<String, String> nvp : paramMap.entrySet()) {
			list.add(new BasicNameValuePair(nvp.getKey(), nvp.getValue()));
		}

		return list;
	}

	/**
	 * 或者相应的http数据
	 * 
	 * @param response
	 *            返回的响应
	 * @return 返回的http响应
	 * @throws IOException
	 * @throws ParseException
	 */
	private static String getResponseStr(HttpResponse response, String charset) throws ParseException, IOException {
		log.info("status code: " + response.getStatusLine().getStatusCode());
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity == null) {
			return null;
		}
		String result = EntityUtils.toString(httpEntity, charset);
		EntityUtils.consume(httpEntity);
		return result;
	}

	/**
	 * 判断请求是否成功
	 * 
	 * @param response
	 *            http请求
	 * @return
	 */
	public static boolean isSuccess(HttpResponse response) {
		return response.getStatusLine().getStatusCode() < 400;
	}

	/**
	 * httpget请求
	 * 
	 * @param url
	 *            请求url
	 * @return httpget请求响应
	 */
	public static String httpGet(String url) {
		return httpGet(url, new HashMap<String, String>());
	}

	/**
	 * httpget请求
	 * 
	 * @param url
	 *            请求url
	 * @param paramMap
	 *            请求参数
	 * @return httpget请求响应
	 */
	public static String httpGet(String url, Map<String, String> paramMap) {
		return httpGet(url, paramMap, 15000, DEFAULT_ENCODING);
	}

	/**
	 * httpget请求
	 * 
	 * @param url
	 *            请求url
	 * @param paramMap
	 *            请求参数
	 * @param timeout
	 *            响应
	 * @return httpget请求响应
	 */
	public static String httpGet(String url, Map<String, String> paramMap, Integer timeout) {
		return httpGet(url, paramMap, timeout, DEFAULT_ENCODING);
	}

	/**
	 * httpget请求
	 * 
	 * @param url
	 *            请求url
	 * @param paramMap
	 *            请求参数
	 * @param timeout
	 *            超时时间单位毫秒，例如2秒-2000毫秒
	 * @param charset
	 *            编码默认utf-8
	 * @return httpget请求响应
	 */
	public static String httpGet(String url, Map<String, String> paramMap, Integer timeout, String charset) {
		if (StringUtils.isBlank(charset)) {
			charset = DEFAULT_ENCODING;
		}
		String queryStr = buildQueryString(paramMap, charset);
		url += ("?" + queryStr);
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = null;
		String result = "";
		try {
			log.info("httpGet request: " + paramMap);
			RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
			httpGet.setConfig(reqConfig);
			httpResponse = getHttpClient().execute(httpGet);
			result = getResponseStr(httpResponse, charset);
			log.info("httpGet response: " + result);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		} finally {
			httpGet.releaseConnection();
		}

		return result;
	}

	/**
	 * httppost请求
	 * 
	 * @param url
	 *            请求url
	 * @param queryParam
	 *            请求参数数据
	 * @param formParams
	 *            表单请求数据
	 * @param charset
	 *            编码utf-8
	 * @param requestBody
	 *            application/json requestbody请求
	 * @return httppost请求响应
	 * @throws UnsupportedEncodingException
	 */
	public static String httpPost(String url, Map<String, String> queryParam, Map<String, String> formParams, String charset, String requestBody)
			throws UnsupportedEncodingException {
		return httpPost(url, queryParam, formParams, DEFAULT_TIME_OUT, charset, requestBody);
	}

	/**
	 * httppost请求
	 * 
	 * @param url
	 *            请求url
	 * @param queryParam
	 *            请求参数数据
	 * @param formParams
	 *            表单请求数据
	 * @param requestBody
	 *            application/json requestbody请求
	 * @return httppost请求响应
	 * @throws UnsupportedEncodingException
	 */
	public static String httpPost(String url, Map<String, String> queryParam, Map<String, String> formParams, String requestBody)
			throws UnsupportedEncodingException {
		return httpPost(url, queryParam, formParams, DEFAULT_ENCODING, requestBody);
	}

	/**
	 * httppost请求
	 * 
	 * @param url
	 *            请求url
	 * @param queryParam
	 *            请求参数数据
	 * @param formParams
	 *            表单请求数据
	 * @return httppost请求响应
	 * @throws UnsupportedEncodingException
	 */
	public static String httpPost(String url, Map<String, String> queryParam, Map<String, String> formParams) throws UnsupportedEncodingException {
		return httpPost(url, queryParam, formParams, null);
	}

	/**
	 * httppost请求
	 * 
	 * @param url
	 *            请求url
	 * @param queryParam
	 *            请求参数数据
	 * @return httppost请求响应
	 * @throws UnsupportedEncodingException
	 */
	public static String httpPostQuery(String url, Map<String, String> queryParam) throws UnsupportedEncodingException {
		return httpPost(url, queryParam, null);
	}

	/**
	 * httppost请求
	 * 
	 * @param url
	 *            请求url
	 * @param formParam
	 *            表单请求数据
	 * @return httppost请求响应
	 * @throws UnsupportedEncodingException
	 */
	public static String httpPostForm(String url, Map<String, String> formParam) throws UnsupportedEncodingException {
		return httpPost(url, null, formParam);
	}
	
	public static String httpPost(String url, String requestBody) throws UnsupportedEncodingException {
		return httpPost(url, null, null, DEFAULT_TIME_OUT, DEFAULT_ENCODING, requestBody);
	}

	/**
	 * httppost请求
	 * 
	 * @param url
	 *            请求url
	 * @param queryParam
	 *            表单请求参数
	 * @param timeout
	 *            超时时间单位毫秒，例如2秒-2000毫秒
	 * @param charset
	 *            编码格式默认utf-8
	 * @param requestBody
	 *            application/json等方式提交的requestbody
	 * @return httppost请求响应
	 * @throws UnsupportedEncodingException
	 */
	public static String httpPost(String url, Map<String, String> queryParam, Map<String, String> formParams, Integer timeout, String charset,
			String requestBody) throws UnsupportedEncodingException {
		if (StringUtils.isBlank(url)) {
			throw new IllegalArgumentException("illegal arg url, it cannot be empty.");
		}

		if (StringUtils.isBlank(charset)) {
			charset = DEFAULT_ENCODING;
		}

		String queryStr = buildQueryString(queryParam, charset);
		if (queryStr != null) {
			url = url + "?" + queryStr;
		}
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> list = toNameValuePairs(formParams);
		if (list != null && list.size() > 0) {
			httpPost.addHeader(CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
			httpPost.setEntity(new UrlEncodedFormEntity(list, charset));
		} else if (StringUtils.isNotBlank(requestBody)) {
			httpPost.addHeader(CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
			httpPost.setEntity(new StringEntity(requestBody, charset));
		}

		HttpResponse response = null;
		try {
			RequestConfig reqConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
			httpPost.setConfig(reqConfig);
			response = getHttpClient().execute(httpPost);

			if (!isSuccess(response)) {
				log.error(response.getStatusLine().getReasonPhrase());
			}

			return getResponseStr(response, charset);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			httpPost.releaseConnection();
		}

	}

}
