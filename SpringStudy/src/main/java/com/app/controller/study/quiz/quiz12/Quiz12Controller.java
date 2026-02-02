package com.app.controller.study.quiz.quiz12;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/quiz12")
public class Quiz12Controller {

	
	@GetMapping("/login")
	public String getLogin() {
	
		return"quiz12/login";
	}
	
	@PostMapping("/login")
	public String postLogin(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("loginId", request.getParameter("id"));
		session.setAttribute("count",0); // 현재 세션에 대한 count 값 초기화 
		
		return "redirect:/quiz12/count";	
	
	}
	
    @GetMapping("/count")
    public String getCount(Model model, HttpSession session) {
    	
    	
    	//int count = 0;
    	//model.addAttribute("count", count++);
    	
    	//count = count+1;
    	
    	//session.getAttribute("loginId");
    	//session.getAttribute("count");  
    	
    	if(session.getAttribute("count") !=null) {
    	
    	session.setAttribute("count", (Integer)(session.getAttribute("count"))+1); 
    	}
        return "quiz12/count";
    }
    
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
    	
//    	session.removeAttribute("loginId");
//    	session.removeAttribute("count");
    	
    	session.invalidate(); // 다 삭제하고 초기화하는 것 
    	
    	return "redirect:/quiz12/count";
    	
    }
    
    
    
    
}
