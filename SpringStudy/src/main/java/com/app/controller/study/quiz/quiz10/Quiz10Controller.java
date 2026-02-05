package com.app.controller.study.quiz.quiz10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Quiz10Controller {

	@GetMapping("/quiz10/A")
	public String a(Model model) {

		model.addAttribute("fromA", "FromA");

		return "quiz/quiz10/a";
	}

	@GetMapping("/quiz10/B")
//	public String b(Model model, HttpServletRequest request) {
//		HttpSession session =  request.getSession();
//		session.setAttribute("fromB", "FromB");
	public String b(Model model, HttpSession session) {
		session.setAttribute("fromB", "FromB");

		model.addAttribute("fromB", "FromB");

		// request 각 요청별 독립
		// session 브라우저(사용자) 별로 구분 사용

		return "quiz/quiz10/b";
	}
}
