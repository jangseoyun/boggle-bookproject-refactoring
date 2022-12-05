package com.javaex.dao;

import com.javaex.dto.playlistFolder.PlaylistCoverDto;
import com.javaex.dto.playlistFolder.PlaylistFolderSearchDto;
import com.javaex.dto.playlistFolder.PlaylistLikeDto;
import com.javaex.vo.PlaylistFolderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Mapper
@Repository
public interface PlaylistFolderDao {

    /* 플레이리스트 폴더 클릭 -> 해당 플레이리스트 서평 리스트  */
    List<PlaylistFolderVo> reviewList(Map<String, Object> ReviewPageCnt);

    /* 플레이리스트 커버 */
    PlaylistCoverDto playlistCover(Long playlistNo);

    /* 해당 플리(folder) 총 서평 수  */
    Long folderReviewCnt(Long playlistNo);

    /* 전체 글갯수 가져오기 */
    Long totalCnt();

    /* 플리 모달 페이징 */
    List<PlaylistFolderVo> madalListPage(Map<String, Integer> pageStartEndMa);

    /* 플리 검색 결과 가져오기 */
    List<PlaylistFolderSearchDto> playlistSearch(String search);

    /* 선택 서평 등록하기 */
    int reviewsInsert(Map<String, Object> reviewInsertMap);

    /* 서평 삭제 */
    int reviewDelete(Long reviewNo);

    /* 로딩시 좋아요 체크 */
    int checkLike(Map<String, Long> likeMap);

    /* 해당 플리 좋아요 취소 */
    int playlistUnlike(PlaylistLikeDto playlistLikeDto);

    /* 해당 플리 좋아요 */
    int playlistLike(PlaylistLikeDto playlistLikeDto);


}
