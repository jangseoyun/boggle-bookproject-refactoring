package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ViewDao;

@Service
public class ViewService {

	@Autowired
	ViewDao viewDao;
	
	public Map<String, Object> getReviewInfo(int reviewNo) {
		System.out.println("ViewService > getReviewInfo");
		
		return viewDao.getReviewInfo(reviewNo);
	}
}
