package com.javaex.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dao.ReviewWriteDao;
import com.javaex.dto.reviewwrite.*;
import com.javaex.util.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewWriteService {
	private final ReviewWriteDao reviewWriteDao;

	public List<Object> addReviewTotalCnt(JSONArray items) {
		log.info("addReviewTotalCnt()");

		for (int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);
			log.info("item.has(\"isbn13\") : " + item.get("isbn13"));

			if (item.get("isbn13") != "") {
				log.info("item isbn13 isn't null");

				String isbn = (String) item.get("isbn13");
				Long isbn13 = Long.parseLong(isbn);
				int totalCnt = reviewWriteDao.getReviewTotalCnt(isbn13);
				items.getJSONObject(i).put("totalCnt", totalCnt);
			}

		}

		List<Object> list = items.toList();
		return list;
	}

	public EmotionStyleResponse getStyle(Long emoNo) {
		List<StyleDto> getEmoStyleResultList = reviewWriteDao.getStyle(emoNo);
		return new EmotionStyleResponse(getEmoStyleResultList);
	}

	public ReviewAddResponse addReview(ReviewAddRequest reviewAddRequest) {
		// 0. 장르 테이블에 이미 저장되어 있는지 확인
		int result = reviewWriteDao.checkGenre(reviewAddRequest.getGenreNo());
		if (result == 0) {
			// 1. 장르 테이블 넣기
			reviewWriteDao.addGenre(reviewAddRequest);
		}

		// 2-1. 책 저장되어 있는지 확인
		int result2 = reviewWriteDao.checkBook(reviewAddRequest.getBookNo());
		if (result2 == 0) {
			// 2. books 테이블 넣기
			reviewWriteDao.addBook(reviewAddRequest);
		}

		// 3. review 테이블에 넣기
		int addResult = reviewWriteDao.addReview(reviewAddRequest);
		if (addResult == 0) {
			throw new IllegalArgumentException("리뷰 등록에 실패했습니다");
		} else {
			return reviewWriteDao.selectReviewOne(reviewAddRequest.getReviewNo());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getBookInfo(String bookTitle) throws JsonProcessingException {
		List<Map<String, Object>> info = new ArrayList<>();

		// 1. db에 책이 이미 있는지 확인
		int bookCnt = reviewWriteDao.findByBookTitle(bookTitle);

		// 2. 없으면 api로 책 정보 불러오기
		if (bookCnt == 0) {
			log.info("db에 없는 책입니다. api 통신 시작");

			// API
			String key = "ttbmay-primavera1830001";

			HashMap<String, Object> result = new HttpUtil()
					.url("http://www.aladin.co.kr/ttb/api/ItemSearch.aspx")
					.method("get")
					.queryString("TTBKey", key)
					.queryString("QueryType", "Title")
					.queryString("query", bookTitle) /* bookNo 만으로 api 검색할 수 없음 - 왜지?? */
					.queryString("output", "js")
					.build();

			String jsonStr = result.get("body").toString();
			jsonStr = jsonStr.substring(0, jsonStr.length() - 1);

			// 2-1. review total count 넣기
			JSONObject jsonObj = new JSONObject(jsonStr);
			JSONArray items = jsonObj.getJSONArray("item");


			for (int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				long isbn13 = item.getLong("isbn13");

				int reviewTotalCnt = reviewWriteDao.getReviewTotalCnt(isbn13);

				items.getJSONObject(i).put("totalCnt", reviewTotalCnt);
			}

			for (Object item : items) {
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

	public Map<String, Object> getPrevReviewInfo(Long reviewNo) {
		return reviewWriteDao.getPrevReviewInfo(reviewNo);
	}

	public int checkReviewWriter(Long reviewNo, Long userNo) {
		Map<String, Long> reviewWriterMap = new HashMap<>();
		reviewWriterMap.put("reviewNo", reviewNo);
		reviewWriterMap.put("userNo", userNo);

		return reviewWriteDao.checkReviewWriter(reviewWriterMap);
	}

	/*public int modifyReview(ReviewModifyRequest reviewModifyRequest) {
		// 해당 서평의 bookNo와 새로 수정한 서평의 bookNo가 일치하는지( 책이 바꿔었는지 ) && db에 없는 책일 경우
		if (reviewWriteDao.checkBookUpdate(reviewModifyRequest) == 0 && reviewWriteDao.checkBook(reviewModifyRequest.getBookNo()) == 0) {
			System.out.println("책도 수정한 경우");
			reviewWriteDao.addGenre(map);
			reviewWriteDao.addBook(map);

			if (reviewWriteDao.checkBook(map) == 0) { // db에 없는 책일 경우
				reviewWriteDao.addGenre(map);
				reviewWriteDao.addBook(map);
			}

		}

		return reviewWriteDao.modifyReview(map);
	}*/

}
