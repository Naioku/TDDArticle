package me.naioku.tdd_article.entities;

import me.naioku.tdd_article.helpers.Coordinates;
import me.naioku.tdd_article.services.trade.TradeService;

public class Player extends Entity {

    TradeService tradeService;

    public Player(int health, Coordinates coordinates) {
        super(health, coordinates);
    }

    void tradeWithNPC(Entity npc) {
        tradeService.tradeWithNPC(this, npc);
    }
}
