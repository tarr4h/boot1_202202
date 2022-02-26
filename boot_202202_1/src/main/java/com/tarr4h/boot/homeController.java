package com.tarr4h.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class homeController {
	
	@GetMapping("/")
	public String goHome() {
		
		return "forward:/index.jsp";
	}
	

}
