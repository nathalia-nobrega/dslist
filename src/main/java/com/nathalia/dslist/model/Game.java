package com.nathalia.dslist.model;

import com.nathalia.dslist.model.gameUtils.GameDescription;
import com.nathalia.dslist.model.gameUtils.Platform;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
// TODO: Implement a GameScore class
// TODO: Implement a Genre class
// TODO: Handle Platform as a Platform enum type

@Entity
@Table(name = "TB_GAME")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable {
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
    @Column(columnDefinition = "TEXT")
    private String short_description;
    @Column(columnDefinition = "TEXT")
    private String long_description;


    private Game(GameBuilder builder) {
        this.title = builder.title;
        this.game_year = builder.game_year;
        this.genre = builder.genre;
        this.platform = builder.platform;
        this.score = builder.score;
        this.img_url = builder.img_url;
        this.short_description = builder.short_description;
        this.long_description = builder.long_description;
    }
    public static class GameBuilder {
        private Long id;
        private String title;
        private Double score;
        private Integer game_year;
        private String genre;
        private String platform;
        private String img_url;
        private String short_description;
        private String long_description;

        public GameBuilder(String title, String genre) {
            this.title = title;
            this.genre = genre;
        }

        public GameBuilder withScore(Double score) {
            this.score = score;
            return this;
        }
        public GameBuilder withGameYear(Integer game_year) {
            this.game_year = game_year;
            return this;
        }
        public GameBuilder withGenre(String genre) {
            this.genre = genre;
            return this;
        }
        public GameBuilder withPlatform(String platform) {
            this.platform = platform;
            return this;
        }
        public GameBuilder withImgUrl(String img_url) {
            this.img_url = img_url;
            return this;
        }
        public GameBuilder withDescription(GameDescription description) {
            this.short_description = description.getShort_description();
            this.long_description = description.getLong_description();
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }

}
