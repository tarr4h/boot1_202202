package com.tarr4h.boot.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tarr4h.boot.member.model.service.MemberService;
import com.tarr4h.boot.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;
		
	@GetMapping("/login")
	public void memberLogin() {
		
	}
	
	@GetMapping("/enrollMain")
	public void enrollMain() {	
		
	}
	
	@PostMapping("/memberEnroll")
	public String memberEnroll(Member member, RedirectAttributes redirectAttr) {
		log.info("member = {}", member);
		
		String encodedPassword = bcryptPasswordEncoder.encode(member.getPassword());
		member.setPassword(encodedPassword);
		
		int result = memberService.insertMember(member);
		log.info("enrollresult = {}", result);
		
		String msg = result > 0 ? "회원가입에 성공했습니다." : "회원 가입 도중 문제가 발생하였습니다.";
		
		redirectAttr.addFlashAttribute("msg", msg);
		
		return "redirect:/member/login";
	}
	
}
