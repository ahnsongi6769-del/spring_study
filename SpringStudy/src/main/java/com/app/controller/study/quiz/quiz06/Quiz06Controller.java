package com.app.controller.study.quiz.quiz06;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz06Controller {


	@GetMapping("/quiz06/ask-bmi")
	public String ask_bmi() {
		return "quiz/quiz06/ask-bmi";
	}
	
	@PostMapping("/quiz06/result-bmi")
	public String result_bmi(HttpServletRequest request) {
		
		//request   name  height   weight
		
		//입력값 확인
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("height"));
		System.out.println(request.getParameter("weight"));
		
		//bmi 지수 계산
		// bmi = 체중(kg) / 키(m)^2    175 -> 1.75
		// 	179.9
		//  59.1
		String name = request.getParameter("name");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		double heightDb = Double.parseDouble(height);
		double weightDb = Double.parseDouble(weight);
		double bmi = weightDb / ( heightDb/100 * heightDb/100);
		
		//printf("%.2f", bmi)
		//String.format("%.2f", bmi) -> String
		//화면에 전달해서 출력
		request.setAttribute("name", name);
		request.setAttribute("height", height);
		request.setAttribute("weight", weight);
		request.setAttribute("bmi", String.format("%.3f", bmi));
		
		
		return "quiz/quiz06/result-bmi";
	}
	
	@PostMapping("/quiz06/result-bmi2")
	public String result_bmi2(@RequestParam String name,
							@RequestParam String height,
							@RequestParam String weight,
							Model model) {
		
		//request   name  height   weight
		
		//입력값 확인
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
		
		//bmi 지수 계산
		// bmi = 체중(kg) / 키(m)^2    175 -> 1.75
		// 	179.9
		//  59.1
//		double heightDb = Double.parseDouble(height);
//		double weightDb = Double.parseDouble(weight);
//		double bmi = weightDb / ( heightDb/100 * heightDb/100);
		double bmi = calculateBmi(height, weight);
		
		//printf("%.2f", bmi)
		//String.format("%.2f", bmi) -> String
		//화면에 전달해서 출력
		model.addAttribute("name", name);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		model.addAttribute("bmi", String.format("%.3f", bmi));
		
		
		return "quiz/quiz06/result-bmi";
	}
	
	
	@PostMapping("/quiz06/result-bmi3")
	public String result_bmi3(@RequestParam Map<String,String> paramMap, Model model) {
		
		//request   name  height   weight

		String name = paramMap.get("name");
		
		//입력값 확인
		System.out.println(paramMap.get("name"));
		System.out.println(paramMap.get("height"));
		System.out.println(paramMap.get("weight"));

		double bmi = calculateBmi(paramMap.get("height"), paramMap.get("weight"));
		
		//printf("%.2f", bmi)
		//String.format("%.2f", bmi) -> String
		//화면에 전달해서 출력
		model.addAttribute("name", paramMap.get("name"));
		model.addAttribute("height", paramMap.get("height"));
		model.addAttribute("weight", paramMap.get("weight"));
		model.addAttribute("bmi", String.format("%.3f", bmi));
		
		
		return "quiz/quiz06/result-bmi";
	}
	
	//@PostMapping("/quiz06/result-bmi4")
	@RequestMapping("/quiz06/result-bmi4")
	public String result_bmi4(@ModelAttribute PersonBmi personBmi, Model model) {
		
		//request   name  height   weight

		//입력값 확인
		System.out.println(personBmi.getName());
		System.out.println(personBmi.getHeight());
		System.out.println(personBmi.getWeight());
		System.out.println(personBmi.getBmi()); //

		double bmi = calculateBmi(personBmi.getHeight(), personBmi.getWeight());
		
		personBmi.setBmi(bmi);
		
		System.out.println(personBmi.getBmi()); //
		
		model.addAttribute("personBmi", personBmi);
		
		return "quiz/quiz06/result-bmi";
	}
	
	
	
	//bmi 계산 메소드
	public double calculateBmi(double height, double weight) {
		//double bmi = weight / ( height/100 * height/100);
		double bmi = weight / Math.pow((height/100), 2);
		return bmi;
	}
	
	public double calculateBmi(String height, String weight) {
		double heightDb = Double.parseDouble(height);
		double weightDb = Double.parseDouble(weight);
		return calculateBmi(heightDb, weightDb);
	}
	
	
	
	
	
	
	
	
	
	
	
}
