package com.nathalia.dslist.dto;

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

    public Long getId() {
        return id;
    }
}
