package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.javaex.dao.HelpDao;
import com.javaex.vo.HelpVo;

@Repository
public class HelpService {
	
	
	@Autowired
	private HelpDao helpDao;
	

	//리스트만 출력할 때 
	public List<HelpVo> getHelpList() {
	System.out.println("helpService/list");
		
		return helpDao.selectList();
	}
	
	// 글쓰기
	public int addHelp(HelpVo helpVo) {
		System.out.println("helpService/addHelp");

		return helpDao.insert(helpVo);
	}
	
//	// 글가져오기
//	@Transactional
//	public HelpDao getHelp1(int no, String type) throws Exception {
//		System.out.println("helpService/getHelp");
//		
//		return helpDao;
//	}

	// 글수정
	public int modifyHelp(HelpVo helpVo) {
		System.out.println("helpService/modifyHelp");

		return helpDao.update(helpVo);
	}

	// 글삭제
	public int removeHelp(HelpVo helpVo) {
		System.out.println("helpService/removeHelp");

		return helpDao.delete(helpVo);
	}
	
	public HelpVo helpSelect(int no){
		System.out.println("helpService/helpSelect");
		HelpVo helpVo = helpDao.select(no);
		
		return helpVo;
	}

	///////
	public HelpVo helpSelect2(int no){
		System.out.println("helpService/helpSelect2");
		HelpVo helpVo = helpDao.select2(no);
		
		return helpVo;
	}
	
	public HelpVo getHelp(int no, String string) {
		System.out.println("helpService/getHelp");
		
		HelpVo helpVo = helpDao.select(no);
		
		return helpVo;
	}
	
	
	
	
}
