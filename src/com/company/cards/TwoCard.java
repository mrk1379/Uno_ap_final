package com.company.cards;

import com.company.design.UI;
import com.company.enums.Color;
import com.company.gameServices.Game;
import com.company.gameServices.GetCommand;
import com.company.gameServices.Player;

/**
 * represents the cards with the sign '2+'
 * add 2 cards
 */
public class TwoCard extends Card {

    /**
     *main  constructor
     * @param color color of the card
     * @param sign sign of the card
     */
    public TwoCard(Color color, String sign) {
        super(color, sign);
    }

    /**
     * the action of the game
     * @param game the game
     */
    @Override
    public void act(Game game) {



        UI.getInstance().choosePlayer(game);
        int playerIndex = GetCommand.getInstance().choosePlayer(game);

        Player player = game.getPlayers().get(playerIndex);
        player.addCard(game.getDeck().pop());
        player.addCard(game.getDeck().pop());


        game.setOnColor(getColor());
        game.nextPerson();
    }
}
