package com.xgc.demo.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class TestController {

	@RequestMapping("/test")
	public String test(){
		return "test";
	}
}
