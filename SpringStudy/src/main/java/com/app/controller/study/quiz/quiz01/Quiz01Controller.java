package com.app.controller.study.quiz.quiz01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Quiz01Controller {

	
	@RequestMapping("/quiz01/main")
	public String quizmain() {
		
		return "quiz01/main";
	}
	
	@RequestMapping("/quiz01/product/mouse")
	public String mouse() {
		
		return "quiz01/product/mouse";
	}
	
	@RequestMapping("/quiz01/product/keyboard")
	public String keyboard() {
		
		return "quiz01/product/keyboard";
	}
	
}
