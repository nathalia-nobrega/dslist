package com.nathalia.dslist.dto;

import com.nathalia.dslist.model.GameList;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class GameListDto {
    private Long id;
    private String name;

    public GameListDto(GameList gameList) {
        BeanUtils.copyProperties(gameList, this);
    }
}
