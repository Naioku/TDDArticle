package me.naioku.tdd_article.services.trade;

import me.naioku.tdd_article.entities.Entity;

public interface TradeService {
    void tradeWithNPC(Entity player, Entity npc);
}
