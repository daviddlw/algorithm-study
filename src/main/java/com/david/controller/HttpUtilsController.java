package com.david.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/utils")
public class HttpUtilsController {

	@ResponseBody
	@RequestMapping(value = "/http_get_query", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public Map<String, Object> httpGetQuery(String id, String name) {
		Map<String, Object> rsMap = new HashMap<String, Object>();
		rsMap.put("id", id + "_" + System.currentTimeMillis());
		rsMap.put("name", name + "_" + System.currentTimeMillis());
		return rsMap;
	}

	@ResponseBody
	@RequestMapping(value = "/http_post_form.json", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/x-www-form-urlencoded")
	public Map<String, Object> httpPostForm(String id, String name) {
		Map<String, Object> rsMap = new HashMap<String, Object>();
		rsMap.put("id", id + "_" + System.currentTimeMillis());
		rsMap.put("name", name + "_" + System.currentTimeMillis());
		return rsMap;
	}

	@ResponseBody
	@RequestMapping(value = "/http_post_body.json", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json")
	public Map<String, Object> httpPostForm(@RequestBody User user) {
		Map<String, Object> rsMap = new HashMap<String, Object>();
		rsMap.put("id", user.getId() + "_" + System.currentTimeMillis());
		rsMap.put("name", user.getName() + "_" + System.currentTimeMillis());
		return rsMap;
	}
}

class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
