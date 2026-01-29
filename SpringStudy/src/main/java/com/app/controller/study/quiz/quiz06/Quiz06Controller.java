package com.app.controller.study.quiz.quiz06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz06")
public class Quiz06Controller {

	@GetMapping("/ask-bmi")
	public String ask_bmi(@ModelAttribute BmiForm bmi) {
		
		
		return"/quiz06/ask-bmi";
	}
	
	@PostMapping("/ask-bmi")
	public String result_bmi(@ModelAttribute BmiForm bmi) {
		
		bmi.setBmi(bmi.getWeight()/(bmi.getHeight()*bmi.getHeight()/10000));
		
		return"/quiz06/result-bmi";
	}
	
}
