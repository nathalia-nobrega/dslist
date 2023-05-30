package com.nathalia.dslist.dto;

import com.nathalia.dslist.model.Game;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * This DTO is sent when we want information about
 * a <b>specific</b></b> game when we acess a list.
 */

@Component
@Data
@NoArgsConstructor
public class GameDto {
    private Long id;
    private String title;
    private Double score;
    private Integer game_year;
    private String genre;
    private String platform;
    private String img_url;
    private String short_description;
    private String long_description;

    public GameDto(Game game) {
        BeanUtils.copyProperties(game, this);
    }
}