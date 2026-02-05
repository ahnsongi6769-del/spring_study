package com.app.controller.study.quiz.quiz02;

import java.lang.annotation.Repeatable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz02Controller {

	
	//@RequestMapping(value="/quiz02/req1", method = RequestMethod.GET)
	@GetMapping("/quiz02/req1")
	public String req1() {
		System.out.println("/quiz02/req1 GET 요청");
		
		return "quiz/quiz02/req";
	}
	
	@PostMapping("/quiz02/req2")
	public String req2() {
		System.out.println("/quiz02/req2 POST 요청");
		
		return "quiz/quiz02/req";
	}
	
	/*
	- GET 방식 POST 방식 상관 없이 모두 수행가능
	- 요청시 "/quiz02/req3 요청" 출력
	- data1과 data2 이름으로 들어온 파라미터 값도 출력
	*/
	
	@RequestMapping("/quiz02/req3")
	//public String req3(@RequestParam String data1, @RequestParam(required = false) String data2) {
	public String req3(HttpServletRequest request) {
		System.out.println("/quiz02/req3 요청");
		
		// localhost:8080/quiz02/req3?data1=111&data2=222
//		System.out.println(data1);
//		System.out.println(data2);
		
		System.out.println(request.getParameter("data1"));
		System.out.println(request.getParameter("data2"));
		
		return "quiz/quiz02/req";
	}
}











