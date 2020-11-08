package com.two.demo.controllertest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("sample/doA")
	public String doA(Model model) {
		logger.info("doA called...");
		
		model.addAttribute("messge", "홈페이지 방문을 환영한다.");
		
		return "sample/doB";
	}
	
	@RequestMapping("sample/doB")
	public void doB() {
		logger.info("doB called ...");
	}
	
	@RequestMapping("sample/doC")
	public ModelAndView doC() {
		logger.info("doC called...");
		
		Map<String, Object> map =new HashMap<String, Object>();
		
		map.put("product", new ProductVO("연필",1000));
		
		return new ModelAndView("sample/doC","map",map);
	}
	
	@RequestMapping("sample/doD")
	public String doD() {
		return "redirect:/sample/doE";
	}
	
	@RequestMapping("sample/doE")
	public void doE() {
		
	}
}
