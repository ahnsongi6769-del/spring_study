package com.app.controller.study.quiz.quiz04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quiz04")
public class Quiz04Controller {
	
	
	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request) {

		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));

		return "quiz04/quiz04";

	}
	
	@GetMapping("/request1-2")
	public String request2(@RequestParam(required = false) String category, @RequestParam(required = false) String product) {
		// (required = false) 요청 파라미터가 없어도 에러 안 나게 하려고 씀
		// 기본적으로 @RequestParam은 파라미터가 꼭 있어야한다는 전제이기 때문에
		System.out.println(category);
		System.out.println(product);

		return "quiz04/quiz04";

	}
	
	@GetMapping("/request1-3")
	public String request3(@ModelAttribute Item item) {
		System.out.println(item);

		return "quiz04/quiz04";
	}
	
	@GetMapping("/request1-4")
	public String request4(@RequestParam Map<String, String> requestMap) {
		

		System.out.println(requestMap.get("category"));
		System.out.println(requestMap.get("product"));

		return "quiz04/quiz04";
	}
	
	@GetMapping("/viewData1-1")
	public String view1(HttpServletRequest request) {

		request.setAttribute("response001", "value001");
		request.setAttribute("response099", "value099");

		return "quiz04/viewData";

	}
	
	@GetMapping("/viewData1-2")
	public String viewData2(Model model) {
		
		model.addAttribute("response001", "value001");
		model.addAttribute("response099", "value099");
		
		return "quiz04/viewData";
	}
	
	
	
	
	@GetMapping("/viewData1-3")
	public ModelAndView view3(ModelAndView mav) {

		mav.setViewName("quiz04/viewData");
		mav.addObject("response001", "value001");
		mav.addObject("response099", "value099");

		return mav;
	}

	@GetMapping("/viewData1-4")
	public String view4(Model model) {

		// 객체 전달
		TransferItem transferItem = new TransferItem();

		transferItem.setValue001("value001");
		transferItem.setValue099("value099");

		model.addAttribute("transferItem", transferItem);

		return "quiz04/viewData";
	}
	
	

}
