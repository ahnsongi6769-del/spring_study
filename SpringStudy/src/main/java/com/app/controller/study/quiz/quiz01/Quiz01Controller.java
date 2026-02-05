package com.app.controller.study.quiz.quiz01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/quiz01")
public class Quiz01Controller {
	
	//@RequestMapping("/quiz01/main")
	@RequestMapping("/main")
	public String main() {
		return "quiz/quiz01/main";
	}
	
	//@RequestMapping("/product/mouse")
	@RequestMapping(value="/product/mouse", method = RequestMethod.GET)
	public String mouse() {
		return "quiz/quiz01/product/mouse";
	}
	
	//@RequestMapping("/product/keyboard")
	@GetMapping("/product/keyboard")
	public String keyboard() {
		return "quiz/quiz01/product/keyboard";
	}
	
}





