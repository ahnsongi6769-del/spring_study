package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request02") // 공통된 부분을 상위레벨로 올려 처리 할 수 있다. 

public class Request02Controller {	

		//@RequestMapping("/request02/url02")
		@RequestMapping("/url02")
		public String url02() { // 주소요청과 보여지는 화면은 다를수 있다. 
			return "url1";
			}

		//@RequestMapping("/request02/url03")
		@RequestMapping("/url03")
		public String url03() { // 주소요청과 보여지는 화면은 다를수 있다. 
			return "url1";
			}

		//@RequestMapping("/request02/url04")
		@RequestMapping("/url04")
		public String url04() { // 주소요청과 보여지는 화면은 다를수 있다. 
			return "url1";
			}

	

}
