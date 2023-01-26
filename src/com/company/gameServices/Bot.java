package com.company.gameServices;

import com.company.cards.Card;
import com.company.design.UI;
import com.company.enums.Color;

import java.util.Random;

/**
 * bot class
 * do possible moves
 * used in single player
 *
 * @author Mohammad Reza Karimi
 */
public class Bot extends Player {

    /**
     * constructor
     * @param name the name of the player
     */
    public Bot(String name) {
        super(name);
    }

    /**
     * It will get a move from the bot
     * @return the card that has been chosen
     */
    @Override
    public Card getMove(Game game) {
        for (Card card : getCards()) {
            if (game.checkValidCard(card))
                return card;
        }
        return null;
    }

    /**
     * It will get a WC card from the player
     * @param game the game
     * @return the WC card
     */
    @Override
    public Card WCmove(Game game) {
        for (Card card : getCards()) {
            if (card.getSign().equals("W"))
                return card;
        }
        return null;
    }

    /**
     * The bot will choose a color
     * @param game the game
     * @return the chosen color
     */
    @Override
    public Color chooseColor(Game game) {
        Random random = new Random();
        Color toReturn;
        switch (random.nextInt(3)) {
            
            case 0:
                toReturn = Color.RED;
                break;
            case 1:
                toReturn = Color.GREEN;
                break;
            case 2:
                toReturn = Color.Yellow;
                break;
            case 3:
                toReturn = Color.BLUE;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + random.nextInt(3));
        }
        UI.getInstance().printBotChoice(toReturn);
        return toReturn;
    }

}
