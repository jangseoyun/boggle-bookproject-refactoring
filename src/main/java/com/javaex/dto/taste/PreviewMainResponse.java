package com.javaex.dto.taste;

import com.javaex.dto.bookmark.BookMarkListResponse;
import com.javaex.dto.mybook.LatestUserLikeReviewsDTO;
import com.javaex.dto.mybook.UserLikeReviewsDTO;
import com.javaex.dto.playlist.LikePlaylistDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreviewMainResponse {
    private List<LatestUserLikeReviewsDTO> latestUserLikeReviews;
    private List<UserLikeReviewsDTO> userLikeReviews;
    private List<LikePlaylistDto> likePlaylistLimitFiv;
    private List<BookMarkListResponse> previewBookmarkLimitFiv;
}
