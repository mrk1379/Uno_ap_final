package com.company.cards;

import com.company.enums.Color;
import com.company.gameServices.Game;

/**
 * class for cards
 * assign value , signs and color
 * @author Mohammad Reza karim
 */
public abstract class Card {
    private Color color;
    private String sign;
    private int value;

    public static final String[] signs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "S", "C", "R","W","2+"};

    /**
     * constructor
     * @param color color of the card
     * @param sign sign of the card
     */
    public Card(Color color, String sign) {
        this.color = color;
        this.sign = sign;
        this.value = switch (sign){
            case "S", "C", "R", "2+" -> 20;
            case "W" -> 50;
            default -> Integer.parseInt(sign);
        };
    }

    /**
     * the action of the card
     * It will be implemented by the subclasses
     * @param game the game
     */
    public abstract void act(Game game);

    /**
     * getter of the Color field
     * @return the color field
     */
    public Color getColor() {
        return color;
    }

    /**
     * getter of the sign field
     * @return the sign field
     */
    public String getSign() {
        return sign;
    }

    /**
     * return value of card
     * @return value
     */
    public int getValue(){
        return value;
    }
}
