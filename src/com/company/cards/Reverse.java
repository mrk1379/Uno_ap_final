package com.company.cards;

import com.company.gameServices.Game;
import com.company.enums.Color;

/**
 * @author  Mohamad Reza Karimi
 */
public class Reverse extends Card {
    /**
     * main constructor
     * @param color color of the card
     * @param sign sign of the card
     */
    public Reverse(Color color, String sign) {
        super(color, sign);
    }

    /**
     * the action of the game
     * @param game the game
     */
    @Override
    public void act(Game game) {
        game.changeDirection();
        game.nextPerson();
        game.nextPerson();
        game.setOnColor(getColor());
    }
}
