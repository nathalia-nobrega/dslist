package com.nathalia.dslist.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GameMinDto {
    private Long id;
    private String title;
    private Integer game_year;
    private String img_url;
    private String short_description;

    public GameMinDto() {
    }

    public Long getId() {
        return id;
    }
}
