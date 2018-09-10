package com.micosoft.css.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.tika.parser.txt.CharsetDetector;

@Controller
public class HomeController {
	
	
	@PostMapping("/get-data")
	public String getData(@RequestParam("data") String myData, Model model ) throws Exception {
		
		CharsetDetector detector = new CharsetDetector();
		detector.setText(myData.getBytes());
		

		
		String encodeing = detector.detect().getName();
		
		logger.debug("the encoding is:" + encodeing);
		logger.error("the encoding is:" + encodeing);
		
		model.addAttribute("mycode", encodeing);
		
		
		return "test";
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

}
