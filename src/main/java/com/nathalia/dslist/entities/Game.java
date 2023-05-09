package com.nathalia.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_GAME")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    private String title;
    private Double score;
    private Integer game_year;
    private String genre;
    private String platform;
    private String img_url;
    @Lob
    private String short_description;
    @Lob
    private String long_description;

    public Game(String title, Integer game_year, String genre, String platform, Double score, String img_url, String short_description, String long_description) {
        this.title = title;
        this.game_year = game_year;
        this.genre = genre;
        this.platform = platform;
        this.score = score;
        this.img_url = img_url;
        this.short_description = short_description;
        this.long_description = long_description;
    }
}