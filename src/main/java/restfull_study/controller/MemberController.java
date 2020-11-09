package restfull_study.controller;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import restfull_study.dto.Member;
import restfull_study.service.MemberService;

@Controller
public class MemberController {
	private static final Log log = LogFactory.getLog(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping("/update")
	public ModelAndView updateMember(@RequestParam(value = "id") long id) {
//		Member member = service.getMember(id);
//		ModelAndView mav = new ModelAndView("member/update", "member", member);
//		return mav;
		ModelAndView mav = new ModelAndView("member/update", "id", id);
		return mav;
	}
}
