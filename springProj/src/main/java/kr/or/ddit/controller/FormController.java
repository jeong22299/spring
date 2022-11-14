package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.MemberListVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/form")
public class FormController {
	
	@GetMapping("/registerForm01")
		public String registerForm01(Model model) {
			log.info("registerForm01");
			
			model.addAttribute("member", new MemberListVO());
			
			return "form/registerForm";
		}
	
	@GetMapping("/registerForm02")
	public String registerForm02(@ModelAttribute MemberListVO memVO) {
		log.info("registerForm02");
		
		return "form/registerForm02";
	}
	
	// <form:form modelAttribute="mamVO" method="post" action="register">
	// 골뱅이ModelAttribute 애너테이션으로 폼 객체의 속성명을 직접 지정할 수 있음
	@GetMapping("/registerForm03")
	public String registerForm03(@ModelAttribute("memVO") MemberListVO memVO, Model model) {
		log.info("registerForm03");
		
		// 폼 객체의 프로퍼티에 값을 미리 지정해놓음
		memVO.setMemId("gaeddoni");
		memVO.setMemName("개똥이");
		memVO.setPassword("java");
		
		Map<String, String> hobbyMap = new HashMap<String, String>();
		hobbyMap.put("Sports", "Sports");
		hobbyMap.put("Music", "Music");
		hobbyMap.put("Movie", "Movie");
		
		Map<String, String> genderMap = new HashMap<String, String>();
		genderMap.put("Male", "Male");
		genderMap.put("Female", "Female");
		genderMap.put("Other", "Other");
		
		// 셀렉트 박스
		Map<String, String> nationalityMap = new HashMap<String, String>();
		nationalityMap.put("Korea", "Korea");
		nationalityMap.put("Germany", "Germany");
		nationalityMap.put("Australia", "Australia");

		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("genderMap", hobbyMap);
		model.addAttribute("nationalityMap", nationalityMap);
		
		return "form/registerForm03";
	}
	
	// 요청 URI :  /form/register
	// 방식 : post
	// 파라미터 : {"memId" : "gaeddongi", "memName" : "개똥이"}
	@PostMapping("/register")
	   public String registerPost(@Validated MemberListVO memVO,BindingResult result,Model model) {
	      log.info(memVO.toString());
	      
	      //register03.jsp에서 post 요청시 validated 확인 후
	      //문제 발생시 폼 화면으로 돌아감
	      String nextPage="";
	      if(result.hasErrors()) {
	         nextPage= "form/registerForm03";
	         return nextPage;
	      }
	      
	      String[] hobbyList = memVO.getHobbyList();
	      if(hobbyList != null) {
	         for (String hobby : hobbyList) {
	            log.info("hobbyList: "+hobby);
	         }
	      }
	      
	      model.addAttribute("hobbyList",hobbyList);
	      nextPage = "form/success";
	      return nextPage;
	   }
	
	
}

















