package com.company.cards;

import com.company.enums.Color;
import com.company.gameServices.Game;

/**
 *  general cards with no action 0-9
 */
public class GeneralCard extends Card {

    /**
     * constructor
     * @param color color of the card
     * @param sign sign of the card
     */
    public GeneralCard(Color color, String sign) {
        super(color, sign);
    }

    /**
     * the action of the game
     * @param game the game
     */
    @Override
    public void act(Game game) {
        game.nextPerson();
        game.setOnColor(getColor());
    }
}
