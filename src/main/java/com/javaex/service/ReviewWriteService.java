package com.javaex.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dao.ReviewWriteDao;
import com.javaex.util.HttpUtil;
import com.javaex.vo.StyleVo;

@Service
public class ReviewWriteService {

	@Autowired
	ReviewWriteDao reviewWriteDao;
	
	public List<Object> addReviewTotalCnt(JSONArray items) {
		System.out.println("ReviewWriteDao > addReviewTotalCnt()");
		
		for(int i = 0; i < items.length(); i++) {
			
			JSONObject item = items.getJSONObject(i); 
			
			System.out.println("item.has(\"isbn13\") : " + item.get("isbn13"));
			
			if(item.get("isbn13") != "") {
				System.out.println("item isbn13 isn't null");
				
				String isbn = (String) item.get("isbn13");
				
				Long isbn13 = Long.parseLong(isbn);

				int totalCnt = reviewWriteDao.getReviewTotalCnt(isbn13);
				
				items.getJSONObject(i).put("totalCnt", totalCnt);
			}

		}
		
		List<Object> list = items.toList();
		
		return list;
	}
	
	public List<StyleVo> getStyle(int emoNo) {
		return reviewWriteDao.getStyle(emoNo);
	}
	
	public int addReview(Map<String, Object> map) {
		
		// 0. 장르 테이블에 이미 저장되어 있는지 확인
		int result = reviewWriteDao.checkGenre(map);
		
		if(result == 0) {
			// 1. 장르 테이블 넣기
			reviewWriteDao.addGenre(map);
		}
		
		// 2-1. 책 저장되어 있는지 확인
		int result2 = reviewWriteDao.checkBook(map);
		
		if(result2 == 0) {
			// 2. books 테이블 넣기
			reviewWriteDao.addBook(map);
		}
		
		// 3. review 테이블에 넣기
		return reviewWriteDao.addReview(map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getBookInfo(String bookTitle) throws JsonParseException, JsonMappingException, IOException {
		
		List<Map<String, Object>> info = new ArrayList<>();
		
		// 1. db에 책이 이미 있는지 확인
		int bookCnt = reviewWriteDao.checkBook(bookTitle);
		
		// 2. 없으면 api로 책 정보 불러오기
		if(bookCnt == 0) {
			System.out.println("db에 없는 책입니다. api 통신 시작");
			
			///////////////////////
			// API
			///////////////////////
			String key = "ttbmay-primavera1830001";
			
			HashMap<String, Object> result = new HttpUtil()
					.url("http://www.aladin.co.kr/ttb/api/ItemSearch.aspx")
					.method("get")
					.queryString("TTBKey", key)
					.queryString("QueryType", "Title")
					.queryString("query", bookTitle) /* bookNo 만으로 api 검색할 수 없음 */
					.queryString("output", "js")
					.build();
			
			String jsonStr = result.get("body").toString();
			jsonStr = jsonStr.substring(0, jsonStr.length() - 1);

			// 2-1. review total count 넣기
			JSONObject jsonObj = new JSONObject(jsonStr);
			JSONArray items = jsonObj.getJSONArray("item");

		
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				long isbn13 = item.getLong("isbn13");

				int reviewTotalCnt = reviewWriteDao.getReviewTotalCnt(isbn13);
				
				items.getJSONObject(i).put("totalCnt", reviewTotalCnt);	
			}

			for(Object item : items) {
				Map<String, Object> itemMap = new ObjectMapper().readValue(item.toString(), Map.class);
				
				info.add(itemMap);
			}

		}
		
		// 3. 있으면 db에서 bookinfo 불러오기
		else {
			info.add(reviewWriteDao.getBookInfo(bookTitle));
				
		}
		
		// 4. 화면에 전달
		return info;	
	}
	
	public Map<String, Object> getPrevReviewInfo(int reviewNo) {
		return reviewWriteDao.getPrevReviewInfo(reviewNo);
	}
	
	public int modifyReview(Map<String, Object> map) {
		
		// 해당 서평의 bookNo와 새로 수정한 서평의 bookNo가 일치하는지( 책이 바꿔었는지 ) && db에 없는 책일 경우
		if(reviewWriteDao.checkBookUpdate(map) == 0 && reviewWriteDao.checkBook(map) == 0) {
			System.out.println("책도 수정한 경우");
			reviewWriteDao.addGenre(map);
			reviewWriteDao.addBook(map);			

			/*
			if(reviewWriteDao.checkBook(map) == 0) { // db에 없는 책일 경우
				reviewWriteDao.addGenre(map);
				reviewWriteDao.addBook(map);
			}
			*/
		}
		
		return reviewWriteDao.modifyReview(map);
	}
}
