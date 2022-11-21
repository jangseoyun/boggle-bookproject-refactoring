package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.HelpVo;

@Repository
public class HelpDao {
	
	@Autowired
	private SqlSession sqlSession;

	
	// 글전체 가져오기(리스트만 출력할때)
	public List<HelpVo> selectList() {
		System.out.println("helpDao/selectList");

		return sqlSession.selectList("help.selectList");
	}
		
	
	// 글 1개 가져오기
	public HelpVo select(int no) {
		System.out.println("helpDao/select");
		//System.out.println(no);
		HelpVo helpVo = sqlSession.selectOne("help.select", no);
		
		return helpVo;
	}
	
	//글 수정할 때 title content 가져오기 
	public HelpVo select2(int no) {
		System.out.println("helpDao/select2");
		System.out.println(no);
		HelpVo helpVo = sqlSession.selectOne("help.modifySelect",no);
		
		return helpVo;
	}
	
	
	// 글저장
	public int insert(HelpVo helpVo) {
		System.out.println("helpDao/insert");
		int saveHelp = sqlSession.insert("help.insert", helpVo);
		System.out.println(saveHelp);
		
		return saveHelp;
	}

	
	// 글수정
	public int update(HelpVo helpVo) {
		System.out.println("helpDao/update");
		
		int updateHelp = sqlSession.update("help.update", helpVo);

		return updateHelp;
	}

	// 글삭제
	public int delete(HelpVo helpVo) {
		System.out.println("helpDao/delete");

		return sqlSession.delete("help.delete", helpVo);
	}
}
