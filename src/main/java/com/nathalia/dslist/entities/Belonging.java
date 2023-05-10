package com.nathalia.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_BELONGING")
public class Belonging {
    @EmbeddedId
    private BelongingPk id = new BelongingPk();
    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        this.id.setGame(game);
        this.id.setList(list);
    }

}
