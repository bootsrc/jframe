package com.frank.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frank.sboot.biz.service.DemoService;

/** 
* @author  Frank Liu
* @version 创建时间：2017年3月6日 下午1:42:17 
* 类说明 
*/
@RequestMapping("")
@Controller
public class HomeController {
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("")
	@ResponseBody
	public String index() {
		return "Success on verify-process.";
	}
	
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update() {
		int id = 6;
		String name = "aaa";
		demoService.updateName(id, name);
		return "Test DB.";
	}
}
