package kr.co.mhj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.mhj.service.TestService;

@Controller
public class TestController {
	@Autowired
	TestService testService;
	
	@RequestMapping(value= "/doA", method=RequestMethod.GET)
	String doA(Model model) {
		System.out.println("doA 호출!");
		String serviceResult = testService.testService1();
		model.addAttribute("msg",serviceResult);
		return "doA";
	}
	@RequestMapping(value = "/doB")
	String doB() {
		return "doB";
	}
}
