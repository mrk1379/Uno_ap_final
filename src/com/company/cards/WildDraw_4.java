package com.company.cards;

import com.company.enums.Color;
import com.company.gameServices.Game;

public class WildDraw_4 extends Card {
    /**
     * constructor
     * @param color color of the card
     * @param sign sign of the card
     */
    public WildDraw_4(Color color, String sign) {
        super(color, sign);

    }

    /**
     * the action of the game
     * @param game the game
     */
    @Override
    public void act(Game game) {
        game.addNextPlayerPenalty(4);
        Color chosen = game.getPlayerOnTurn().chooseColor(game);
        game.setOnColor(chosen);
        game.nextPerson();

    }
}
