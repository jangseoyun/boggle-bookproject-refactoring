package com.javaex.service;

import com.javaex.dao.BookmarkDao;
import com.javaex.dao.MybookDao;
import com.javaex.dao.PlaylistDao;
import com.javaex.dto.bookmark.BookMarkListResponse;
import com.javaex.dto.mybook.LatestUserLikeReviewsDTO;
import com.javaex.dto.mybook.UserLikeReviewsDTO;
import com.javaex.dto.playlist.LikePlaylistDto;
import com.javaex.dto.taste.PreviewMainResponse;
import com.javaex.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TasteService {

    private final MybookDao mybookDao;
    private final PlaylistDao playlistDao;
    private final BookmarkDao bookmarkDao;

    public PreviewMainResponse checkAccessUserAndViewResponse(UserDto pageUser, UserDto loginUser) {
        if (pageUser.getNickname().equals(loginUser.getNickname())) {
            Long loginUserNo = loginUser.getUserNo();
            //response에 담기
            //해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
            List<LatestUserLikeReviewsDTO> latestUserLikeReviews = mybookDao.latestUserLikeReviews(loginUserNo);
            //해당유저 넘버를 주면 좋아요한 서평리스트를 출력하는 메소드 + 해당유저의 서평 총 갯수 출력
            List<UserLikeReviewsDTO> userLikeReviews = mybookDao.userLikeReviews(loginUserNo);
            //해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
            List<LikePlaylistDto> likePlaylistLimitFiv = playlistDao.previewPlaylistLimitFiv(loginUserNo);
            //해당유저넘버를 주면 좋아요한 책 목록을 출력하는 메소드
            List<BookMarkListResponse> previewBookmarkLimitFiv = bookmarkDao.previewBookmarkLimitFiv(loginUserNo);
            return new PreviewMainResponse(latestUserLikeReviews, userLikeReviews, likePlaylistLimitFiv, previewBookmarkLimitFiv);

        } else {
            //해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
            List<LatestUserLikeReviewsDTO> latestUserLikeReviews = mybookDao.latestUserLikeReviews(pageUser.getUserNo());
            //해당유저 넘버를 주면 좋아요한 서평리스트를 출력하는 메소드+해당유저의 서평 총 갯수 출력
            List<UserLikeReviewsDTO> userLikeReviews = mybookDao.userLikeReviews(pageUser.getUserNo());
            //해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
            List<LikePlaylistDto> likePlaylistLimitFiv = playlistDao.previewPlaylistLimitFiv(pageUser.getUserNo());
            //해당유저넘버를 주면 좋아요한 책 목록을 출력하는 메소드
            List<BookMarkListResponse> previewBookmarkLimitFiv = bookmarkDao.previewBookmarkLimitFiv(pageUser.getUserNo());
            return new PreviewMainResponse(latestUserLikeReviews, userLikeReviews, likePlaylistLimitFiv, previewBookmarkLimitFiv);
        }
    }


}
