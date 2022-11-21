package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.ViewService;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	ViewService viewService;
	
	@RequestMapping("/{reviewNo}")
	public String viewer(@PathVariable(value="reviewNo") int reviewNo,
						 Model model) {
		System.out.println("ViewController > viewer()");
		
		Map<String, Object> info = viewService.getReviewInfo(reviewNo);

		model.addAttribute("info", info);
		
		return "viewer/viewer";
	}
}
