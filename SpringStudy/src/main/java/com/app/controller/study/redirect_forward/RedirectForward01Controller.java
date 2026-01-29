package com.app.controller.study.redirect_forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectForward01Controller {

	@GetMapping("/re/re1")
	public String re1() {
		return "re/re1"; // re1  요청 -> re1 페이지
	}
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) {
		
		System.out.println("/re/re2");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		return "re/re2"; //re2  요청 -> re2 페이지
	}
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {
		
		System.out.println("/re/re3");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		return "re/re2"; //re3  요청 -> re2 페이지
	}
	
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request) {
		
		System.out.println("/re/re4");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		return "re/re4"; //re4  요청 -> re4 페이지 -> (view) code 페이지 내부 -> 경로 이동 -> /re/re2 요청
	}
	
	@GetMapping("/re/re5")
	public String re5(HttpServletRequest request) {
		
		System.out.println("/re/re5");
		System.out.println(request.getParameter("msg"));
		
		
		return "redirect:/re/re2"; //redirect: 요청 날릴 경로
		// 화면view 이름 아니라 경로를 요청한다의 기준으로 판단해야함. 
		// return view이름 / WEB_INF/views/ re/re2 . jsp
		// return redirect: 주소경로 localhost /re/re2 주소창에 들어갈 경로 
	}
	
	@GetMapping("/re/re6")
	public String re6(HttpServletRequest request) {
		
		//서버에서 forward 처리 
		System.out.println("/re/re6");
		System.out.println(request.getParameter("msg"));
		
		
		//forward 는 서버에서 바로 요청 경로를 이동하여 수행
		return "forward:/re/re2"; // forward : 요청경로 GetMepping 경로 
		
	}
	
	@GetMapping("/re/re7")
	public String re7(HttpServletRequest request, RedirectAttributes ra) {
		
		//서버에서 redirect 응답 
		System.out.println("/re/re7");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
				// attribute , parameter view 전달용 ->request 가 발생 ( 기존 request 값이 넘어가지 않는다)
		
		//RedirectAttributes 활용
		ra.addAttribute("msg","hihello");
		ra.addAttribute("stats","tired");
		//redirect 요청 시 -> 경로 뒤에 파라미터로 추가 해줌 
		//http://localhost:8080/re/re2?msg=hihello&stats=tired
		// redirect 로 요청 받은 메소드 측에서도 경로에 있는 parameter 확인 가능
		
		ra.addFlashAttribute("msg","flashHello");
		//http://localhost:8080/re/re2
		// 요청 주소에 표시되지 않고, 주소는 redirect 명시된 주소 그대로 
		//redirect 요청 받은 서버측 메소드에서 화면에서 확인용으로 전달 (model에 저장됨)
		
		return "redirect:/re/re2"; 
		//msg를 redirect 시에 넘기고 싶으면 주소 경로 자체를 넘기는 형태로 작성한다. 
		// return " redirect:/re/re2?msg="+request.getParameter("msg");
					//" redirect:/re/re2?msg= hihi
		
	}
	
	
	
}
