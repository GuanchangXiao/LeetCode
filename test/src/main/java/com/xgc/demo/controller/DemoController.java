package com.xgc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/index")
    public String index(){
		System.out.println("aaa");
        return "test";
    }
	@RequestMapping(value="/test",method={RequestMethod.GET,RequestMethod.POST})
	public String test(){
        return "test";
    }
}
