package com.app.controller.study.quiz.quiz08;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz08Controller {

	
//	"/quiz08/member?auth=basic"
//	"/quiz08/member?auth=manager"
//	"/quiz08/member?auth=admin" 
	
	@GetMapping("/quiz08/member")
	public String member(@RequestParam String auth, Model model) {

		
		//사전에 파라미터 경로 필터링
		if(  !(auth.equals("basic") || auth.equals("manager") || auth.equals("admin") ) ) {
			//파라미터 auth 가 basic manager admin 이 아닌 다른 값이 들어온 경우!
			return "잘못되었다~하는 페이지~";
		}
		
		List<Member> memberList = new ArrayList<Member>();

		memberList.add(new Member("user1", "pass123", "홍길동", "basic"));
		memberList.add(new Member("user2", "pass456", "김철수", "manager"));
		memberList.add(new Member("user3", "pass789", "이영희", "basic"));
		memberList.add(new Member("user4", "passabc", "박민지", "manager"));
		memberList.add(new Member("user5", "passdef", "정재영", "basic"));
		memberList.add(new Member("user6", "passxyz", "최성민", "basic"));
		memberList.add(new Member("user7", "pass123", "서지원", "manager"));
		memberList.add(new Member("user8", "pass456", "장성호", "basic"));
		memberList.add(new Member("user9", "pass789", "신지수", "basic"));
		memberList.add(new Member("user10", "passabc", "한영희", "manager"));
		
		// 1) 서버에서 데이터 분리 -> 화면에 전달할 데이터만 선별 -> view 전달 -> view 는 그냥 출력
		List<Member> viewMemberList = new ArrayList<Member>();
		
//		if(auth.equals("basic")) {
//			for(Member m : memberList) {
//				if(m.getType().equals("basic")) {
//					viewMemberList.add(m);
//				}
//			}
//		} else if ( auth.equals("manager") ) {
//			for(Member m : memberList) {
//				if(m.getType().equals("manager")) {
//					viewMemberList.add(m);
//				}
//			}
//		} else {  //auth=admin
//			viewMemberList = memberList;
//		}
		
		if(auth.equals("basic") || auth.equals("manager")) {
			for(Member m : memberList) {
				if(m.getType().equals(auth)) {  //m.getType().equals(auth) || auth.equals("admin")
					viewMemberList.add(m);
				}
			}
		} else {  //auth=admin
			viewMemberList = memberList;
		}
		
		model.addAttribute("viewMemberList", viewMemberList);
		
		
		// 2) 서버에서 준비된 데이터 화면에 전달 -> view 화면에서 출력 대상 선별
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("auth", auth);
		
		
		return "quiz/quiz08/member";
		
	}
}










