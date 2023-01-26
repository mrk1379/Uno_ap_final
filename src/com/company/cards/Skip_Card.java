package com.company.cards;

import com.company.enums.Color;
import com.company.gameServices.Game;

public class Skip_Card extends Card {
    /**
     * main constructor
     * @param color color of the card
     * @param sign sign of the card
     */
    public Skip_Card(Color color, String sign) {
        super(color, sign);
    }

    /**
     * the action of the game
     * @param game the game
     */
    @Override
    public void act(Game game) {
        game.nextPerson();
        game.nextPerson();
        game.setOnColor(getColor());
    }
}
