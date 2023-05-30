package com.nathalia.dslist.dto;

import com.nathalia.dslist.model.Game;
import com.nathalia.dslist.projections.GameMinDtoProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This DTO is sent when we request the <b>list</b> of games.
 * We want only essential information about each game shown in the list,
 * theferore, there is no need to show every single information.
 */
@Component
@Data
@NoArgsConstructor
public class GameMinDto {
    private Long id;
    private String title;
    private Integer game_year;
    private String img_url;
    private String short_description;

    public GameMinDto(Game game) {
        id = game.getId();
        title = game.getTitle();
        game_year = game.getGame_year();
        img_url = game.getImg_url();
        short_description = game.getShort_description();
    }

    public GameMinDto(GameMinDtoProjection gameProjection) {
        id = gameProjection.getId();
        title = gameProjection.getTitle();
        game_year = gameProjection.getYear();
        img_url = gameProjection.getImgUrl();
        short_description = gameProjection.getShortDescription();
    }
}
