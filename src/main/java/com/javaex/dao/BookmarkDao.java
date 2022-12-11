package com.javaex.dao;

import com.javaex.dto.bookmark.BookMarkListResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Mapper
@Repository
public interface BookmarkDao {

	/*북마크 리스트 */
	List<BookMarkListResponse> bookMarkList(String userEmail);
	
	/*책 수 가져오기*/
//	public int countotal() {
//		System.out.println("Dao.countTotal");
//		int countTtl = sqlSession.selectOne("bookmark.countTotal");
//		return countTtl;
//	}
}
//	
//	public BookmarkVo getBmList(int bookNo, int userNo) {
//		
//		Map<String, Integer> bmlist = new HashMap<String, Integer>();
//		bmlist.put("bookNo", userNo);
//		bmlist.put("userNo", userNo);
//		
//		BookmarkVo bmList = sqlSession.selectOne("bookmark.bookMarkList", bmlist);
//		
//		return bmList;
//	}
//}

