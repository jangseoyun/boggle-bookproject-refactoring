package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ViewDao {

	@Autowired
	SqlSession sqlSession;
	
	public Map<String, Object> getReviewInfo(int reviewNo) {		
		Map<String, Object> map = sqlSession.selectOne("emotion.getReviewInfo", reviewNo);
		
		return map;
	}
}
