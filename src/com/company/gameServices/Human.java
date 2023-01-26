package com.company.gameServices;

import com.company.cards.Card;
import com.company.design.UI;
import com.company.enums.Color;

/**
 * human class
 * moves of person playing
 *
 * @author Mohammad Reza Karimi
 */
public class Human extends Player {

    /**
     * constructor
     * @param name the name of the player
     */
    public Human(String name) {
        super(name);
    }

    /**
     * It will get a move from the player
     * @return the card that has been chosen
     */
    @Override
    public Card getMove(Game game) {
        Card currentCard;
        do {
            UI.getInstance().printToChooseCard();
            int index = GetCommand.getInstance().chooseIndex(game.getPlayerOnTurn());
            currentCard = game.getPlayerOnTurn().getCards().get(index);
        } while (!game.checkValidCard(currentCard));
        return currentCard;
    }

    /**
     * It will get a WC cart from the player
     * @param game the game
     * @return the WIld draw darccard
     */
    @Override
    public Card WCmove(Game game) {
        Card currentCard;
        do {
            UI.getInstance().printToChooseCard();
            int index = GetCommand.getInstance().chooseIndex(game.getPlayerOnTurn());
            currentCard = game.getPlayerOnTurn().getCards().get(index);
        } while (!currentCard.getSign().equals("W"));
        return currentCard;
    }

    /**
     * The player will choose a color
     * @param game the game
     * @return the chosen color
     */
    @Override
    public Color chooseColor(Game game) {
        UI.getInstance().printColors();
        return GetCommand.getInstance().chooseColor();
    }

}
