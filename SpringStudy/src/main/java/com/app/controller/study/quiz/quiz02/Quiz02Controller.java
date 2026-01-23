package com.app.controller.study.quiz.quiz02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz02Controller {
	
	// localhost:8080/quiz02/req1
	
	@GetMapping("/quiz02/req1")
	public String getReq() {
		System.out.println("/quiz02/req1 GET 요청");
		return "/quiz02/req1";
	}
	
	// @RequestMapping(value = "/quiz02/req1" , method = RequestMethod.GET)
	
	
	@PostMapping("/quiz02/req2")
	public String PostReq() {
		System.out.println("/quiz02/req2 POST 요청");
		return "/quiz02/req2";
	}
	
	@RequestMapping("/quiz02/req3")
		public String req(@RequestParam String data1, @RequestParam String data2) {
		
		//localhost:8080/quiz02/req3?data1=1&data2=2
		System.out.println("/quiz02/req3 요청");
		System.out.println(data1);
		System.out.println(data2);
		
		return "/quiz02/req3";
	}
	
	

}
