package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.HelpService;
import com.javaex.vo.HelpVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/help")
public class HelpController {
	
	
	@Autowired
	private HelpService helpService;
	
	@RequestMapping("")
	public String help(Model model) {
		System.out.println("helpController/help");
		
		List<HelpVo> helpList = helpService.getHelpList();
		System.out.println(helpList);
		
		model.addAttribute("helpList", helpList);
		
		return "help/help";
	}
	
	// 글쓰기 폼 
	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("helpController/writeForm");
		
		return "help/writeForm";
	}
	
	// 글쓰기
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute HelpVo helpVo, HttpSession session) {
		System.out.println("helpContoller/write");

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		helpVo.setUserNo(authUser.getUserNo());
		helpService.addHelp(helpVo);

		return "redirect:/help/list";
	}
	
	// 리스트(리스트만 출력할때)
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("helpContoller/list");

		List<HelpVo> helpList = helpService.getHelpList();
		System.out.println(helpList);
		
		model.addAttribute("helpList", helpList);
		return "help/list";
	}
	
	// 글읽기
	@RequestMapping(value = "/read", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("helpController/read");
		
		try {
			HelpVo helpVo = helpService.getHelp(no, "read");
			model.addAttribute("helpVo", helpVo);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return "help/read";
	}
	
	// 글 수정폼 
	@RequestMapping("/modifyForm")
	public String modifyForm(@RequestParam ("no") int no, Model model) {
		System.out.println("helpController/modifyForm");
		System.out.println(no);
		HelpVo boardVo = helpService.helpSelect2(no);
		model.addAttribute("boardVo",boardVo);
		System.out.println(boardVo);
		
		return "help/modifyForm";
	}
	
	//글 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute HelpVo helpVo, Model model) {
		System.out.println("helpContoller/modify");
		System.out.println(helpVo);
		
		helpService.modifyHelp(helpVo);
	
		return "redirect:/help/list";
	}
	
	
	//글 삭제
	@RequestMapping(value = "/delete", method ={ RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute HelpVo helpVo, HttpSession session) {
		System.out.println("helpContoller/delete");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		helpVo.setUserNo(authUser.getUserNo());
		helpService.removeHelp(helpVo);
		
		return "redirect:/help/list";
	}
	
	
	///////////  footer에 들어가는 정보 ///////////////
	@RequestMapping("/legal")
	public String legal() {
		System.out.println("legal");
		
		return "help/legal";
	}
	
	@RequestMapping("/privacy")
	public String privacy() {
		System.out.println("privacy");
		
		return "help/privacy";
	}
	
	@RequestMapping("/youth")
	public String youth() {
		System.out.println("youth");
		
		return "help/youth";
	}
	
	

}
