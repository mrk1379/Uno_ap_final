package com.company.cards;

import com.company.enums.Color;
import com.company.gameServices.Game;

/**
 * wild color class
 * player can change color
 */
public class WildColor_Card extends Card {
    /**
     * main  constructor of class
     * @param color color of the card
     * @param sign sign of the card
     */
    public WildColor_Card(Color color, String sign) {
        super(color, sign);
    }

    /**
     * the action of card
     * @param game the game
     */
    @Override
    public void act(Game game) {

        Color chosen = game.getPlayerOnTurn().chooseColor(game);
        game.setOnColor(chosen);

        game.nextPerson();
    }
}
