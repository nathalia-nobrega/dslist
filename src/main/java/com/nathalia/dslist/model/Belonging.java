package com.nathalia.dslist.model;

import com.nathalia.dslist.projections.BelongingProjection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_BELONGING")
public class Belonging {
    @EmbeddedId
    private BelongingId id = new BelongingId();
    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        this.id.setGame(game);
        this.id.setList(list);
    }

    public Belonging(BelongingProjection projection) {
        this.id.getGame().setId(projection.getGameId());
        this.id.getList().setId(projection.getListId());
        this.position = projection.getPosition();
    }

}
