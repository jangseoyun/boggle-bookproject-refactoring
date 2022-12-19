package com.javaex.service;

import com.javaex.dao.BookmarkDao;
import com.javaex.dao.MybookDao;
import com.javaex.dao.PlaylistDao;
import com.javaex.dto.bookmark.BookMarkListResponse;
import com.javaex.dto.mybook.LatestUserLikeReviewsDTO;
import com.javaex.dto.mybook.UserLikeReviewsDTO;
import com.javaex.dto.playlist.LikePlaylistDto;
import com.javaex.dto.playlist.PopularPlayListDTO;
import com.javaex.dto.taste.PreviewMainResponse;
import com.javaex.dto.taste.PreviewPlaylistResponse;
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


    public PreviewPlaylistResponse checkAccessUserAndPlayList(UserDto pageUser, UserDto loginUser) {
        if (pageUser.getNickname().equals(loginUser.getNickname())) {
            // 세션아이디의 유저넘버
            Long loginUserNo = loginUser.getUserNo();
            //해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
            List<LikePlaylistDto> likePlaylistLimitFiv = playlistDao.previewPlaylistLimitFiv(loginUserNo);
            //인기있는 플레이리스트 출력하는 메소드
            List<PopularPlayListDTO> popularPlayListLimitFiv = playlistDao.popularPlaylistLimitFiv();
            //특정 유저 넘버 주면, 해당 유저가 만든 플리 리스트 출력
            List<PopularPlayListDTO> playListByUserLimitFiv = playlistDao.playListByUserLimitFiv(loginUserNo);
            return new PreviewPlaylistResponse(likePlaylistLimitFiv, popularPlayListLimitFiv, playListByUserLimitFiv);
        } else {
            // 지금 서재 닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드 사용
            Long pageUserNo = pageUser.getUserNo();
            //해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
            List<LikePlaylistDto> likePlaylistLimitFiv = playlistDao.previewPlaylistLimitFiv(pageUserNo);
            //인기있는 플레이리스트 출력하는 메소드
            List<PopularPlayListDTO> popularPlaylistLimitFiv = playlistDao.popularPlaylistLimitFiv();
            //특정 유저 넘버 주면, 해당 유저가 만든 플리 리스트 출력
            List<PopularPlayListDTO> playListByUserLimitFiv = playlistDao.playListByUserLimitFiv(pageUserNo);
            return new PreviewPlaylistResponse(likePlaylistLimitFiv, popularPlaylistLimitFiv, playListByUserLimitFiv);
        }

    }

}
