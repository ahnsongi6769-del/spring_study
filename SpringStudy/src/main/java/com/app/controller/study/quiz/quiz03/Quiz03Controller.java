package com.app.controller.study.quiz.quiz03;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {

	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request) {

		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));

		return "quiz03/request1-1";

	}

	@GetMapping("/request1-2")
	public String request2(@RequestParam(required = false) String item, @RequestParam(required = false) String type) {
		// (required = false) 요청 파라미터가 없어도 에러 안 나게 하려고 씀
		// 기본적으로 @RequestParam은 파라미터가 꼭 있어야한다는 전제이기 때문에
		System.out.println(item);
		System.out.println(type);

		return "quiz03/request1-1";

	}

	@GetMapping("/request1-3")
	public String request3(@RequestParam Map<String, String> requestMap) {
		// localhost:8080/quiz03/request1-3?item=americano&type=coffee

		System.out.println(requestMap.get("item"));
		System.out.println(requestMap.get("type"));

		return "quiz03/request1-1";
	}

	@PostMapping("/request1-4")
	public String request4(@ModelAttribute Drink drink) {
		System.out.println(drink);

		return "quiz03/request1-1";
	}

	@GetMapping("/request1-5")
	public String request5(HttpServletRequest request) {

		request.setAttribute("item", "americano");
		request.setAttribute("type", "coffee");

		return "quiz03/request1-1";

	}

	@GetMapping("/request1-6")
	public String request6(@RequestParam(required = false) String search, Model model) {

		model.addAttribute("item", "americano");
		model.addAttribute("type", "coffee");

		if (search != null) {
			if (search.equals("커피")) {
				Drink d = new Drink();
				d.setItem("americano");
				d.setType("coffee");

				model.addAttribute("drink", d);

			}
		}

		return "quiz03/request1-1";
	}

	@GetMapping("/request1-7")
	public ModelAndView request7(ModelAndView mav) {

		mav.setViewName("quiz03/request1-1");
		mav.addObject("item", "americano");
		mav.addObject("type", "coffee");

		return mav;
	}

	@GetMapping("/request1-8")
	public String request8(Model model) {

		// 객체 전달
		Drink drink = new Drink();

		drink.setItem("americano");
		drink.setType("coffee");

		model.addAttribute("drinkItem", drink);

		return "quiz03/request1-1";
	}

}
