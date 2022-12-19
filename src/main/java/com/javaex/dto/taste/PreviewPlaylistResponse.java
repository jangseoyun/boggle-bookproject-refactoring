package com.javaex.dto.taste;

import com.javaex.dto.playlist.LikePlaylistDto;
import com.javaex.dto.playlist.PopularPlayListDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PreviewPlaylistResponse {
    private List<LikePlaylistDto> likePlaylistLimitFiv;
    private List<PopularPlayListDTO> popularPlayListLimitFiv;
    private List<PopularPlayListDTO> playListByUserLimitFiv;
}
