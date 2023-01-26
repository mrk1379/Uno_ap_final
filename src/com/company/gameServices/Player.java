package com.company.gameServices;

import com.company.cards.Card;
import com.company.enums.Color;
import com.company.gameServices.Game;

import java.util.LinkedList;

/**
 * player class
 * check moves
 * direct moves
 *
 * @author Mohammad Reza Karimi
 */
public abstract class Player {
    private String name;
    private LinkedList<Card> cards;

    public Player(String name) {
        this.name = name;
        cards = new LinkedList<>();
    }

    /**
     * getter of the cards
     * @return the cards list
     */
    public LinkedList<Card> getCards() {
        return cards;
    }

    /**
     * add a specific card to the players deck
     * @param card the card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * getter of the name field
     * @return the name field
     */
    public String getName() {
        return name;
    }

    /**
     * It will check if the player can do anything or not
     * @param game the game
     * @return true if he can and false otherwise
     */
    public boolean checkIfCanMove(Game game) {
        for (Card card : cards) {
            if (game.checkValidCard(card))
                return true;

        }

            if (CheckWC()) {
                return true;
            }

        return false;
    }

    public boolean checkIfCanMoveWithoutWC(Game game) {
        for (Card card : cards) {
            if (game.checkValidCardwwc(card))
                return true;

        }



        return false;
    }

    /**
     * It adds the first card of the out cards deck to the player's deck
     * @param game the game
     */
    public void addOneCard(Game game) {
        cards.add(game.getDeck().pop());
    }

    /**
     * check Wc in player deck
     * used for when a current WC is in use
     * @return true if he has a WC card and false otherwise
     */
    public boolean CheckWC() {
        for (Card card : cards) {
            if (card.getSign().equals("W"))
                return true;
        }
        return false;
    }

    /**
     * It will calculate the score of the player
     * @return the score of the player
     */
    public int calculateScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getValue();
        }
        return score;
    }

    /**
     * It will get a move from the player
     * @return the car that has been chosen
     */
    public abstract Card getMove(Game game);

    /**
     * It will get a WC cart from the player
     * @param game the game
     * @return the WC card
     */
    public abstract Card WCmove(Game game);

    /**
     * The player will choose a color
     * @param game the game
     * @return the chosen color
     */
    public abstract Color chooseColor(Game game);

}
